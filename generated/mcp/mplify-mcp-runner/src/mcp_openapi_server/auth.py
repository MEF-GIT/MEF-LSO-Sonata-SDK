from __future__ import annotations

import asyncio
import time
from dataclasses import dataclass
from typing import Any, AsyncGenerator, Optional

import httpx


class AuthConfigError(ValueError):
    pass


def parse_basic_credentials(value: str) -> tuple[str, str]:
    if ":" not in value:
        raise AuthConfigError("Basic credentials must be in form user:password")
    user, pwd = value.split(":", 1)
    if not user:
        raise AuthConfigError("Basic auth username is empty")
    return user, pwd


@dataclass
class OAuthRefreshConfig:
    token_url: str
    client_id: str
    refresh_token: str
    client_secret: str | None = None
    scope: str | None = None
    audience: str | None = None
    extra_params: dict[str, str] | None = None


class OAuthRefreshTokenAuth(httpx.Auth):
    """httpx.Auth that uses OAuth2 Refresh Token Grant.

    - Fetches access_token from token_url.
    - Adds `Authorization: Bearer <access_token>`.
    - Refreshes when token is near expiry, or once on 401.

    This is intentionally small and template-friendly.
    """

    requires_response_body = True

    def __init__(
        self,
        *,
        token_url: str,
        client_id: str,
        refresh_token: str,
        client_secret: str | None = None,
        scope: str | None = None,
        audience: str | None = None,
        refresh_skew_s: float = 30.0,
        timeout_s: float = 20.0,
        extra_params: dict[str, str] | None = None,
    ) -> None:
        self._cfg = OAuthRefreshConfig(
            token_url=token_url,
            client_id=client_id,
            refresh_token=refresh_token,
            client_secret=client_secret,
            scope=scope,
            audience=audience,
            extra_params=extra_params,
        )
        self._refresh_skew_s = refresh_skew_s
        self._timeout_s = timeout_s

        self._lock = asyncio.Lock()
        self._access_token: str | None = None
        self._expires_at: float | None = None
        self._token_client: httpx.AsyncClient | None = None

    async def __aenter__(self) -> "OAuthRefreshTokenAuth":
        # Dedicated client so token fetch is never affected by this auth.
        self._token_client = httpx.AsyncClient(timeout=self._timeout_s)
        return self

    async def __aexit__(self, exc_type, exc, tb) -> None:  # noqa: ANN001
        if self._token_client is not None:
            await self._token_client.aclose()
            self._token_client = None

    def _is_token_valid(self) -> bool:
        if not self._access_token:
            return False
        if self._expires_at is None:
            # No expiry info: treat as valid until we get a 401.
            return True
        return time.time() < (self._expires_at - self._refresh_skew_s)

    async def _refresh(self) -> None:
        async with self._lock:
            if self._is_token_valid():
                return

            client = self._token_client
            if client is None:
                # Allow usage without context manager (still works, just a bit slower).
                client = httpx.AsyncClient(timeout=self._timeout_s)
                close_after = True
            else:
                close_after = False

            data: dict[str, str] = {
                "grant_type": "refresh_token",
                "client_id": self._cfg.client_id,
                "refresh_token": self._cfg.refresh_token,
            }
            if self._cfg.client_secret:
                data["client_secret"] = self._cfg.client_secret
            if self._cfg.scope:
                data["scope"] = self._cfg.scope
            if self._cfg.audience:
                data["audience"] = self._cfg.audience
            if self._cfg.extra_params:
                data.update(self._cfg.extra_params)

            try:
                resp = await client.post(
                    self._cfg.token_url,
                    data=data,
                    headers={"Accept": "application/json"},
                )
                resp.raise_for_status()
                payload = resp.json()
            except Exception as e:  # noqa: BLE001
                raise AuthConfigError(f"Token refresh failed: {e}") from e
            finally:
                if close_after:
                    await client.aclose()

            access_token = payload.get("access_token")
            if not access_token:
                raise AuthConfigError("Token response missing access_token")

            self._access_token = str(access_token)

            # Token rotation support
            new_refresh = payload.get("refresh_token")
            if new_refresh:
                self._cfg.refresh_token = str(new_refresh)

            expires_in = payload.get("expires_in")
            if expires_in is None:
                self._expires_at = None
            else:
                try:
                    self._expires_at = time.time() + float(expires_in)
                except Exception:
                    self._expires_at = None

    async def async_auth_flow(
        self, request: httpx.Request
    ) -> AsyncGenerator[httpx.Request, httpx.Response]:
        # 1) Ensure token (if expired/absent)
        if not self._is_token_valid():
            await self._refresh()

        if self._access_token:
            request.headers["Authorization"] = f"Bearer {self._access_token}"

        response = yield request

        # 2) On 401, refresh once and retry
        if response.status_code == 401:
            await self._refresh()
            if self._access_token:
                request.headers["Authorization"] = f"Bearer {self._access_token}"
            yield request

