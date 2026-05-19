# Step-by-Step Example: OpenAPI Petstore

This example shows a full, reproducible flow for running this project against a local [OpenAPI Petstore](https://github.com/OpenAPITools/openapi-petstore) instance.

## Prerequisites

- Docker
- Python 3.11+
- Node.js (for MCP Inspector)

## 1. Install this project locally

From the repository root:

```bash
uv venv
source .venv/bin/activate
uv pip install -e .
```

Verify the CLI command is available:

```bash
mplify-mcp-server --help
```

## 2. Start Petstore in Docker

```bash
docker pull openapitools/openapi-petstore
docker run -d \
  --name petstore \
  -e OPENAPI_BASE_PATH=/v3 \
  -e DISABLE_OAUTH=1 \
  -p 9000:8080 \
  openapitools/openapi-petstore
```

The upstream API base URL is `http://localhost:9000/v3`.
The OpenAPI document is `http://localhost:9000/openapi.json`.

## 3. Start the MCP server

In a second terminal (with the same virtual environment activated):

```bash
source .venv/bin/activate
mplify-mcp-server \
  --openapi-uri http://localhost:9000/openapi.json \
  --server-uri http://localhost:9000/v3 \
  --auth basic \
  --basic-credentials "user:user" \
  --listen-host 0.0.0.0 \
  --listen-port 8000 \
  --transport http
```

## 4. Connect with MCP Inspector

In a third terminal:

```bash
npx @modelcontextprotocol/inspector http://localhost:8000/mcp
```

This opens a web UI where you can inspect and call generated tools (for example, `listPets` and `createPets`).

## 5. Optional checks

Confirm Petstore is reachable:

```bash
curl -s http://localhost:9000/v3/pet/findByStatus?status=available | head
```

Stop and clean up when done:

```bash
docker rm -f petstore
```

## Troubleshooting

- `command not found: mcp-openapi-server`:
  Use `mplify-mcp-server` (this project's CLI entrypoint).
- `command not found: mplify-mcp-server`:
  Activate your venv and run `uv pip install -e .` again.
