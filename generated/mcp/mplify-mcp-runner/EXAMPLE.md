# Example Usage with OpenAPI Petstore

This guide demonstrates how to run `mcp-openapi-server` against a local instance of the [OpenAPI Petstore](https://github.com/OpenAPITools/openapi-petstore).

## Prerequisites

- Docker
- Python 3.10+
- Node.js (for the MCP Inspector)
- `mcp-openapi-server` installed (run `pip install -e .` in the project root)

## Step 1: Run the Petstore Server

Start the Petstore server using Docker. This exposes the API on port 9000.

```bash
docker pull openapitools/openapi-petstore
docker run -d -e OPENAPI_BASE_PATH=/v3 -e DISABLE_OAUTH=1 -p 9000:8080 openapitools/openapi-petstore
```

> **Note**: We map port 9000 to the container's 8080. The API will be available at `http://localhost:9000/v3`.

## Step 2: Run the MCP Server

Run `mcp-openapi-server` pointing to the local Petstore instance. We'll use the OpenAPI spec provided by the Petstore itself.

```bash
mcp-openapi-server \
  --openapi-uri http://localhost:9000/openapi.json \
  --server-uri http://localhost:9000/v3 \
  --auth basic \
  --basic-credentials "user:user" \
  --listen-host 0.0.0.0 \
  --listen-port 8000 \
  --transport sse
```

## Step 3: Run the MCP Inspector

Use the MCP Inspector to interact with your server.

```bash
npx @modelcontextprotocol/inspector http://localhost:8000/sse
```

This will open a web interface where you can explore the tools generated from the Petstore OpenAPI spec (e.g., `listPets`, `createPets`, etc.).
