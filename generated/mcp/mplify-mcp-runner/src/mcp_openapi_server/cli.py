from __future__ import annotations

from typing import Optional

import typer

from .openapi_loader import load_openapi_spec
from .server import AuthMode, ServerConfig, create_mcp_server
from .banner_util import print_banner


app = typer.Typer(add_completion=False, help="Expose OpenAPI as an MCP server (FastMCP).")


@app.command()
def run(
    openapi_uri: str = typer.Option(
        ..., "--openapi-uri", envvar="MCP_OAS_URI", help="URL or file path to OpenAPI spec"
    ),
    server_uri: Optional[str] = typer.Option(
        None,
        "--server-uri",
        envvar="MCP_SERVER_URI",
        help="Upstream API base URL. If omitted uses OpenAPI servers[0].url",
    ),
    name: str = typer.Option(
        "Mplify MCP Server", "--name", envvar="MCP_SERVER_NAME", help="MCP server name"
    ),
    auth: AuthMode = typer.Option(
        "none",
        "--auth",
        envvar="MCP_AUTH_MODE",
        help="Upstream auth mode: none | basic | oauth-refresh",
    ),
    basic_credentials: Optional[str] = typer.Option(
        None,
        "--basic-credentials",
        envvar="MCP_BASIC_CREDENTIALS",
        help='Basic auth credentials in form "user:password"',
    ),
    oauth_token_url: Optional[str] = typer.Option(
        None,
        "--oauth-token-url",
        envvar="MCP_OAUTH_TOKEN_URL",
        help="OAuth token endpoint (refresh token grant)",
    ),
    oauth_client_id: Optional[str] = typer.Option(
        None,
        "--oauth-client-id",
        envvar="MCP_OAUTH_CLIENT_ID",
        help="OAuth client_id",
    ),
    oauth_client_secret: Optional[str] = typer.Option(
        None,
        "--oauth-client-secret",
        envvar="MCP_OAUTH_CLIENT_SECRET",
        help="OAuth client_secret (optional)",
    ),
    oauth_refresh_token: Optional[str] = typer.Option(
        None,
        "--oauth-refresh-token",
        envvar="MCP_OAUTH_REFRESH_TOKEN",
        help="OAuth refresh_token",
    ),
    oauth_scope: Optional[str] = typer.Option(
        None,
        "--oauth-scope",
        envvar="MCP_OAUTH_SCOPE",
        help="OAuth scope (optional)",
    ),
    oauth_audience: Optional[str] = typer.Option(
        None,
        "--oauth-audience",
        envvar="MCP_OAUTH_AUDIENCE",
        help="OAuth audience (optional, provider-specific)",
    ),
    transport: str = typer.Option(
        "http",
        "--transport",
        envvar="MCP_TRANSPORT",
        help="Transport mode: http | stdio | sse",
    ),
    listen_host: str = typer.Option(
        "0.0.0.0", "--listen-host", envvar="MCP_LISTEN_HOST", help="Bind host"
    ),
    listen_port: int = typer.Option(
        8000, "--listen-port", envvar="MCP_LISTEN_PORT", help="Bind port"
    ),
    request_timeout_s: float = typer.Option(
        30.0,
        "--request-timeout",
        envvar="MCP_REQUEST_TIMEOUT",
        help="Timeout for upstream API requests (seconds)",
    ),
    openapi_timeout_s: float = typer.Option(
        30.0,
        "--openapi-timeout",
        envvar="MCP_OPENAPI_TIMEOUT",
        help="Timeout for fetching OpenAPI spec (seconds)",
    ),
) -> None:
    """Run the MCP server over HTTP at /mcp."""
    print_banner(
        server_name=name,
        transport=transport,
        listen_host=listen_host,
        listen_port=listen_port,
        openapi_uri=openapi_uri,
    )
    spec = load_openapi_spec(openapi_uri, timeout_s=openapi_timeout_s)

    cfg = ServerConfig(
        openapi_spec=spec,
        server_uri=server_uri,
        name=name,
        auth_mode=auth,
        basic_credentials=basic_credentials,
        oauth_token_url=oauth_token_url,
        oauth_client_id=oauth_client_id,
        oauth_client_secret=oauth_client_secret,
        oauth_refresh_token=oauth_refresh_token,
        oauth_scope=oauth_scope,
        oauth_audience=oauth_audience,
        request_timeout_s=request_timeout_s,
    )

    mcp = create_mcp_server(cfg)
    # Built-in HTTP server
    mcp.run(transport=transport, host=listen_host, port=listen_port, show_banner=False)


def main() -> None:
    app()


if __name__ == "__main__":
    main()

