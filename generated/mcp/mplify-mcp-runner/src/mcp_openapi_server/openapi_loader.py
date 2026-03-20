from __future__ import annotations

import json
import os
from dataclasses import dataclass
from pathlib import Path
from typing import Any, Mapping

import httpx
import yaml


class OpenAPILoadError(RuntimeError):
    pass


def _looks_like_url(value: str) -> bool:
    return value.startswith("http://") or value.startswith("https://")


def load_openapi_spec(uri: str, timeout_s: float = 30.0) -> dict[str, Any]:
    """Load OpenAPI from URL or file path. Supports JSON and YAML."""
    if _looks_like_url(uri):
        try:
            r = httpx.get(uri, timeout=timeout_s)
            r.raise_for_status()
        except Exception as e:  # noqa: BLE001
            raise OpenAPILoadError(f"Failed to fetch OpenAPI spec from {uri}: {e}") from e
        return _parse_spec_text(r.text, hint=uri)

    # local path
    p = Path(uri.replace("file://", ""))
    if not p.exists():
        raise OpenAPILoadError(f"OpenAPI spec file not found: {p}")
    try:
        text = p.read_text(encoding="utf-8")
    except Exception as e:  # noqa: BLE001
        raise OpenAPILoadError(f"Failed to read OpenAPI spec file {p}: {e}") from e
    return _parse_spec_text(text, hint=str(p))


def _parse_spec_text(text: str, hint: str) -> dict[str, Any]:
    # Try JSON first
    try:
        obj = json.loads(text)
        if isinstance(obj, dict):
            return obj
    except Exception:
        pass

    # YAML fallback
    try:
        obj = yaml.safe_load(text)
        if isinstance(obj, dict):
            return obj
    except Exception as e:  # noqa: BLE001
        raise OpenAPILoadError(f"Failed to parse OpenAPI as JSON or YAML ({hint}): {e}") from e

    raise OpenAPILoadError(f"OpenAPI document was not an object/dict ({hint})")


def infer_server_uri(openapi_spec: Mapping[str, Any]) -> str:
    """Infer upstream server base URL from openapi.servers[0].url.

    Applies default values for server variables.
    """
    servers = openapi_spec.get("servers")
    if not isinstance(servers, list) or not servers:
        raise OpenAPILoadError(
            "--server-uri not provided and OpenAPI spec has no servers[0].url"
        )

    first = servers[0]
    if not isinstance(first, dict) or "url" not in first:
        raise OpenAPILoadError("OpenAPI servers[0] is missing url")

    url = str(first["url"])
    variables = first.get("variables")
    if isinstance(variables, dict):
        for var_name, var_def in variables.items():
            if not isinstance(var_def, dict):
                continue
            default = var_def.get("default")
            if default is None:
                continue
            url = url.replace("{" + var_name + "}", str(default))
    return url

