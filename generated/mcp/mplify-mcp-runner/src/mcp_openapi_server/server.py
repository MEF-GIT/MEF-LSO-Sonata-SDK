from __future__ import annotations

import json
from dataclasses import dataclass
from typing import Any, Literal

import httpx
from fastmcp import FastMCP

from .auth import OAuthRefreshTokenAuth, parse_basic_credentials
from .openapi_loader import infer_server_uri
from .utils import strip_nulls


AuthMode = Literal["none", "basic", "oauth-refresh"]


@dataclass
class ServerConfig:
    openapi_spec: dict[str, Any]
    server_uri: str | None
    name: str
    auth_mode: AuthMode
    sanitize_payloads: bool = True

    basic_credentials: str | None = None

    oauth_token_url: str | None = None
    oauth_client_id: str | None = None
    oauth_client_secret: str | None = None
    oauth_refresh_token: str | None = None
    oauth_scope: str | None = None
    oauth_audience: str | None = None

    request_timeout_s: float = 30.0


async def on_request_sanitize_payload(request: httpx.Request) -> None:
    if request.content:
        try:
            json_data = request.json()
            cleaned_data = strip_nulls(json_data)
            request.content = json.dumps(cleaned_data).encode('utf-8')
            request.headers["content-length"] = str(len(request.content))
        except Exception:
            pass  # If parsing fails, leave the content unchanged


async def on_response_sanitize_payload(response: httpx.Response) -> None:
    await response.aread()
    if response.content:
        try:
            json_data = response.json()
            cleaned_data = strip_nulls(json_data)
            response._content = json.dumps(cleaned_data).encode('utf-8')
            response.headers["content-length"] = str(len(response._content))
        except Exception:
            pass  # If parsing fails, leave the content unchanged


def build_auth(cfg: ServerConfig) -> httpx.Auth | None:
    if cfg.auth_mode == "none":
        return None

    if cfg.auth_mode == "basic":
        if not cfg.basic_credentials:
            raise ValueError("--basic-credentials is required when --auth=basic")
        user, pwd = parse_basic_credentials(cfg.basic_credentials)
        return httpx.BasicAuth(user, pwd)

    if cfg.auth_mode == "oauth-refresh":
        missing = [
            k
            for k, v in {
                "--oauth-token-url": cfg.oauth_token_url,
                "--oauth-client-id": cfg.oauth_client_id,
                "--oauth-refresh-token": cfg.oauth_refresh_token,
            }.items()
            if not v
        ]
        if missing:
            raise ValueError(
                "Missing required OAuth settings for --auth=oauth-refresh: "
                + ", ".join(missing)
            )

        return OAuthRefreshTokenAuth(
            token_url=cfg.oauth_token_url or "",
            client_id=cfg.oauth_client_id or "",
            client_secret=cfg.oauth_client_secret,
            refresh_token=cfg.oauth_refresh_token or "",
            scope=cfg.oauth_scope,
            audience=cfg.oauth_audience,
        )

    raise ValueError(f"Unsupported auth mode: {cfg.auth_mode}")


def build_upstream_client(cfg: ServerConfig) -> httpx.AsyncClient:
    base_url = cfg.server_uri or infer_server_uri(cfg.openapi_spec)

    event_hooks = {}
    if cfg.sanitize_payloads:
        event_hooks = {
            "request": [on_request_sanitize_payload],
            "response": [on_response_sanitize_payload],
        }

    auth = build_auth(cfg)
    return httpx.AsyncClient(
        base_url=base_url,
        timeout=cfg.request_timeout_s,
        auth=auth,
        event_hooks=event_hooks,
    )


def create_mcp_server(cfg: ServerConfig) -> FastMCP:
    client = build_upstream_client(cfg)
    return FastMCP.from_openapi(
        openapi_spec=cfg.openapi_spec,
        client=client,
        name=cfg.name,
    )

