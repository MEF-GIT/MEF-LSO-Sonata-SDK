
# mplify-mcp-server

Expose **MEF LSO standards**  as **MCP tools** using **FastMCP**.

This server is designed to make **Mplify standard APIs** accessible through the Model Context Protocol, enabling AI assistants to interact with MEF LSO OpenAPI specifications. It automatically maps MEF API endpoints to MCP tools using `FastMCP.from_openapi()`.

## Features

- Load MEF LSO (Mplify) OpenAPI specifications from a **URL** or **local file** (JSON/YAML)
- Support for Allegro, Legato, and Presto API standards
- Optional override of upstream base URL (`--server-uri`)
  - If omitted, uses `openapi.servers[0].url` (with variable defaults applied)
- Upstream authentication:
  - **Basic Auth** (`user:password`)
  - **OAuth2 Refresh Token Grant** (auto refresh)
- Run MCP server over the network via FastMCP’s built-in HTTP transport
  - default endpoint: `http://<host>:<port>/mcp`

## Quickstart

The fastest way to get started is using Docker:

```bash
# Build the image
docker build -t mplify-mcp-server .

# Run with environment variables
docker run --rm -p 8000:8000 \
  -e MCP_OAS_URI=https://api.example.com/openapi.json \
  -e MCP_SERVER_URI=https://api.example.com \
  -e MCP_AUTH_MODE=basic \
  -e MCP_BASIC_CREDENTIALS="user:password" \
  mplify-mcp-server
```

Or mount a local OpenAPI spec file:

```bash
docker run --rm -p 8000:8000 \
  -v "$PWD/specs:/specs" \
  mplify-mcp-server \
  --openapi-uri /specs/openapi.yaml \
  --server-uri https://api.example.com \
  --auth basic \
  --basic-credentials "user:password"
```

The MCP server will be available at `http://localhost:8000/mcp`.

## Local use

### Option 1: Using UV (Recommended)

[UV](https://github.com/astral-sh/uv) is a fast Python package installer and resolver.

```bash
# Install UV if not already installed
curl -LsSf https://astral.sh/uv/install.sh | sh

# Create a virtual environment and install the package
uv venv
source .venv/bin/activate  # On Linux/macOS
# .venv\Scripts\activate  # On Windows

uv pip install -e .

# Or run directly without activating the environment
uv run mplify-mcp-server --help

# Or install directly from the repository
uv pip install git+https://github.com/Amartus/mplify-mcp-runner.git
```

### Option 2: Using Python/pip

Ensure you're using Python 3.11 or higher (as specified in `pyproject.toml`):

```bash
# Check Python version
python --version  # Should be 3.11+

# If you have multiple Python versions, use the specific one:
python3.11 -m venv .venv
source .venv/bin/activate  # On Linux/macOS
# .venv\Scripts\activate  # On Windows

# Upgrade pip
pip install -U pip

# Install the package in editable mode
pip install -e .
```

### Verify Installation

```bash
mplify-mcp-server --help
```

## CLI usage

### Basic auth example (MEF API)

```bash
mplify-mcp-server \
  --openapi-uri https://mef-api.example.com/mef/legato/openapi.json \
  --server-uri https://mef-api.example.com \
  --auth basic \
  --basic-credentials "user:password" \
  --listen-host 0.0.0.0 \
  --listen-port 8000
```

### OAuth refresh token grant example (MEF API)

```bash
mplify-mcp-server \
  --openapi-uri ./mef-allegro-openapi.yaml \
  --server-uri https://mef-api.example.com \
  --auth oauth-refresh \
  --oauth-token-url https://mef-api.example.com/oauth/token \
  --oauth-client-id YOUR_CLIENT_ID \
  --oauth-client-secret YOUR_CLIENT_SECRET \
  --oauth-refresh-token YOUR_REFRESH_TOKEN
```

### Environment variables

All options can be provided via env vars (CLI flags override env vars):

| Option | Env var | Description |
|---|---|---|
| `--openapi-uri` | `MCP_OAS_URI` | URL or file path to OpenAPI spec |
| `--server-uri` | `MCP_SERVER_URI` | Upstream API base URL |
| `--name` | `MCP_SERVER_NAME` | MCP server name |
| `--auth` | `MCP_AUTH_MODE` | Auth mode: `none`, `basic`, `oauth-refresh` |
| `--basic-credentials` | `MCP_BASIC_CREDENTIALS` | `user:password` for basic auth |
| `--oauth-token-url` | `MCP_OAUTH_TOKEN_URL` | OAuth token endpoint |
| `--oauth-client-id` | `MCP_OAUTH_CLIENT_ID` | OAuth client ID |
| `--oauth-client-secret` | `MCP_OAUTH_CLIENT_SECRET` | OAuth client secret |
| `--oauth-refresh-token` | `MCP_OAUTH_REFRESH_TOKEN` | OAuth refresh token |
| `--oauth-scope` | `MCP_OAUTH_SCOPE` | OAuth scope |
| `--oauth-audience` | `MCP_OAUTH_AUDIENCE` | OAuth audience |
| `--transport` | `MCP_TRANSPORT` | Transport mode: `http`, `stdio`, `sse` |
| `--listen-host` | `MCP_LISTEN_HOST` | Bind host (default: 0.0.0.0) |
| `--listen-port` | `MCP_LISTEN_PORT` | Bind port (default: 8000) |
| `--request-timeout` | `MCP_REQUEST_TIMEOUT` | Timeout for upstream requests (s) |
| `--openapi-timeout` | `MCP_OPENAPI_TIMEOUT` | Timeout for fetching spec (s) |

## Configuration with TOML

You can configure the MCP server using a TOML file. Create a `config.toml`:

```toml
[mcp]
openapi_uri = "https://mef-api.example.com/mef/legato/openapi.json"
server_uri = "https://mef-api.example.com"
name = "mplify-legato-server"
auth = "oauth-refresh"
transport = "http"
listen_host = "0.0.0.0"
listen_port = 8000
request_timeout = 30
openapi_timeout = 10

[mcp.oauth]
token_url = "https://mef-api.example.com/oauth/token"
client_id = "YOUR_CLIENT_ID"
client_secret = "YOUR_CLIENT_SECRET"
refresh_token = "YOUR_REFRESH_TOKEN"
scope = "api:read api:write"
audience = "https://mef-api.example.com"

# For basic auth instead:
# [mcp.basic]
# credentials = "user:password"
```

Then load it in your application or pass via environment variables as shown above.

### Claude Desktop Configuration

To use this MCP server with Claude Desktop, add to your `claude_desktop_config.json`:

```json
{
  "mcpServers": {
    "mplify-server": {
      "command": "uvx",
      "args": [
        "--from",
        "/path/to/mplify-mcp-runner",
        "mplify-mcp-server",
        "--openapi-uri",
        "https://mef-api.example.com/mef/legato/openapi.json",
        "--server-uri",
        "https://mef-api.example.com",
        "--auth",
        "basic",
        "--basic-credentials",
        "user:password",
        "--transport",
        "stdio"
      ]
    }
  }
}
```

Or using installed Python environment:

```json
{
  "mcpServers": {
    "mplify-server": {
      "command": "/path/to/.venv/bin/python",
      "args": [
        "-m",
        "mcp_openapi_server.cli",
        "--openapi-uri",
        "https://mef-api.example.com/mef/allegro/openapi.json",
        "--server-uri",
        "https://mef-api.example.com",
        "--auth",
        "basic",
        "--basic-credentials",
        "user:password",
        "--transport",
        "stdio"
      ]
    }
  }
}
```

## Notes / security

- Prefer env vars or secret managers for credentials.
- This server exposes MEF LSO (Mplify) API operations as MCP tools for AI assistants.
- You may want to curate which OpenAPI routes become tools based on your use case.
