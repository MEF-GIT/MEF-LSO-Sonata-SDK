# Example Usage

This guide demonstrates how to run `mplify-mcp-server` against the blended APIs.

## Prerequisites

- Docker
- Optional: Node.js 

Run the commands in this guide from the `generated/mcp` directory.

```powershell
Set-Location .\generated\mcp
```

## Build the docker container 

```bash
docker build -t mplify-mcp-server mplify-mcp-runner
```

```powershell
docker build -t mplify-mcp-server mplify-mcp-runner
```

## Run server for APIs



### Run the MCP Server for Product Offering Qualification

Before running the container, update `PRODUCT_OFFERING_QUALIFICATION.env` with the correct values.

```bash
docker run --rm -p 8000:8000 \
  -v $(pwd):/data \
  --env-file ./PRODUCT_OFFERING_QUALIFICATION.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8000:8000 `
  -v "${PWD}:/data" `
  --env-file .\PRODUCT_OFFERING_QUALIFICATION.env `
  mplify-mcp-server
```



### Run the MCP Server for Product Offering Availability And Pricing Discovery

Before running the container, update `PRODUCT_OFFERING_AVAILABILITY_AND_PRICING_DISCOVERY.env` with the correct values.

```bash
docker run --rm -p 8001:8000 \
  -v $(pwd):/data \
  --env-file ./PRODUCT_OFFERING_AVAILABILITY_AND_PRICING_DISCOVERY.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8001:8000 `
  -v "${PWD}:/data" `
  --env-file .\PRODUCT_OFFERING_AVAILABILITY_AND_PRICING_DISCOVERY.env `
  mplify-mcp-server
```



### Run the MCP Server for Quote

Before running the container, update `QUOTE.env` with the correct values.

```bash
docker run --rm -p 8002:8000 \
  -v $(pwd):/data \
  --env-file ./QUOTE.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8002:8000 `
  -v "${PWD}:/data" `
  --env-file .\QUOTE.env `
  mplify-mcp-server
```



### Run the MCP Server for Product Inventory

Before running the container, update `PRODUCT_INVENTORY.env` with the correct values.

```bash
docker run --rm -p 8003:8000 \
  -v $(pwd):/data \
  --env-file ./PRODUCT_INVENTORY.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8003:8000 `
  -v "${PWD}:/data" `
  --env-file .\PRODUCT_INVENTORY.env `
  mplify-mcp-server
```



### Run the MCP Server for Product Order

Before running the container, update `PRODUCT_ORDER.env` with the correct values.

```bash
docker run --rm -p 8004:8000 \
  -v $(pwd):/data \
  --env-file ./PRODUCT_ORDER.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8004:8000 `
  -v "${PWD}:/data" `
  --env-file .\PRODUCT_ORDER.env `
  mplify-mcp-server
```



### Run the MCP Server for Billing Management

Before running the container, update `BILLING_MANAGEMENT.env` with the correct values.

```bash
docker run --rm -p 8005:8000 \
  -v $(pwd):/data \
  --env-file ./BILLING_MANAGEMENT.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8005:8000 `
  -v "${PWD}:/data" `
  --env-file .\BILLING_MANAGEMENT.env `
  mplify-mcp-server
```



### Run the MCP Server for Product Catalog

Before running the container, update `PRODUCT_CATALOG.env` with the correct values.

```bash
docker run --rm -p 8006:8000 \
  -v $(pwd):/data \
  --env-file ./PRODUCT_CATALOG.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8006:8000 `
  -v "${PWD}:/data" `
  --env-file .\PRODUCT_CATALOG.env `
  mplify-mcp-server
```



### Run the MCP Server for Circuit Impairment And Maintenance

Before running the container, update `CIRCUIT_IMPAIRMENT_AND_MAINTENANCE.env` with the correct values.

```bash
docker run --rm -p 8007:8000 \
  -v $(pwd):/data \
  --env-file ./CIRCUIT_IMPAIRMENT_AND_MAINTENANCE.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8007:8000 `
  -v "${PWD}:/data" `
  --env-file .\CIRCUIT_IMPAIRMENT_AND_MAINTENANCE.env `
  mplify-mcp-server
```



### Run the MCP Server for Geographic Address Management

Before running the container, update `GEOGRAPHIC_ADDRESS_MANAGEMENT.env` with the correct values.

```bash
docker run --rm -p 8008:8000 \
  -v $(pwd):/data \
  --env-file ./GEOGRAPHIC_ADDRESS_MANAGEMENT.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8008:8000 `
  -v "${PWD}:/data" `
  --env-file .\GEOGRAPHIC_ADDRESS_MANAGEMENT.env `
  mplify-mcp-server
```



### Run the MCP Server for Geographic Site Management

Before running the container, update `GEOGRAPHIC_SITE_MANAGEMENT.env` with the correct values.

```bash
docker run --rm -p 8009:8000 \
  -v $(pwd):/data \
  --env-file ./GEOGRAPHIC_SITE_MANAGEMENT.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8009:8000 `
  -v "${PWD}:/data" `
  --env-file .\GEOGRAPHIC_SITE_MANAGEMENT.env `
  mplify-mcp-server
```



### Run the MCP Server for Trouble Ticket Management

Before running the container, update `TROUBLE_TICKET_MANAGEMENT.env` with the correct values.

```bash
docker run --rm -p 8010:8000 \
  -v $(pwd):/data \
  --env-file ./TROUBLE_TICKET_MANAGEMENT.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8010:8000 `
  -v "${PWD}:/data" `
  --env-file .\TROUBLE_TICKET_MANAGEMENT.env `
  mplify-mcp-server
```



### Run the MCP Server for Appointment Management

Before running the container, update `APPOINTMENT_MANAGEMENT.env` with the correct values.

```bash
docker run --rm -p 8011:8000 \
  -v $(pwd):/data \
  --env-file ./APPOINTMENT_MANAGEMENT.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8011:8000 `
  -v "${PWD}:/data" `
  --env-file .\APPOINTMENT_MANAGEMENT.env `
  mplify-mcp-server
```



### Run the MCP Server for Work Order Management

Before running the container, update `WORK_ORDER_MANAGEMENT.env` with the correct values.

```bash
docker run --rm -p 8012:8000 \
  -v $(pwd):/data \
  --env-file ./WORK_ORDER_MANAGEMENT.env \
  mplify-mcp-server
```

```powershell
docker run --rm -p 8012:8000 `
  -v "${PWD}:/data" `
  --env-file .\WORK_ORDER_MANAGEMENT.env `
  mplify-mcp-server
```



## Step 2 Run the MCP Inspector

Optionally, use the MCP Inspector to interact with your server.

```bash
npx @modelcontextprotocol/inspector http://localhost:<<port>>/mcp
```

This will open a web interface where you can explore the tools generated from the OpenAPI specs.


### Context to Product Offering Qualification MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8000/mcp
```


### Context to Product Offering Availability And Pricing Discovery MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8001/mcp
```


### Context to Quote MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8002/mcp
```


### Context to Product Inventory MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8003/mcp
```


### Context to Product Order MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8004/mcp
```


### Context to Billing Management MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8005/mcp
```


### Context to Product Catalog MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8006/mcp
```


### Context to Circuit Impairment And Maintenance MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8007/mcp
```


### Context to Geographic Address Management MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8008/mcp
```


### Context to Geographic Site Management MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8009/mcp
```


### Context to Trouble Ticket Management MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8010/mcp
```


### Context to Appointment Management MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8011/mcp
```


### Context to Work Order Management MCP Server

```bash
npx @modelcontextprotocol/inspector http://localhost:8012/mcp
```



## VS Code setup

Add an MCP server entry for each API that points at the running container.

1. Start the MCP container first and confirm the target URL is running, for example `http://localhost:8006/mcp`.
2. Configure servers in your **user `mcp.json`** file (this is the preferred location in current VS Code MCP setup).
3. Add all servers in one place in that user MCP configuration.
4. Save the file.
5. If the server does not appear immediately, run `Developer: Reload Window`.
6. Open Copilot Chat and use agent mode or the tools picker. The configured MCP server should now be available there.
7. If you are using an older VS Code MCP implementation, use the legacy `mcp.servers` setting in **User Settings JSON**.
8. If `mcp.servers` appears grayed out, it is in the wrong scope or unsupported by that settings scope.

Legacy fallback example (`mcp.servers` in User Settings JSON):

```json
{
  "mcp.servers": {
    "Product Catalog": {
      "url": "http://localhost:8006/mcp"
    },
    "Product Order": {
      "url": "http://localhost:8004/mcp"
    }
  }
}
```


### Product Offering Qualification

```json
{
  "mcp.servers": {
    "Product Offering Qualification": {
      "url": "http://localhost:8000/mcp"
    }
  }
}
```


### Product Offering Availability And Pricing Discovery

```json
{
  "mcp.servers": {
    "Product Offering Availability And Pricing Discovery": {
      "url": "http://localhost:8001/mcp"
    }
  }
}
```


### Quote

```json
{
  "mcp.servers": {
    "Quote": {
      "url": "http://localhost:8002/mcp"
    }
  }
}
```


### Product Inventory

```json
{
  "mcp.servers": {
    "Product Inventory": {
      "url": "http://localhost:8003/mcp"
    }
  }
}
```


### Product Order

```json
{
  "mcp.servers": {
    "Product Order": {
      "url": "http://localhost:8004/mcp"
    }
  }
}
```


### Billing Management

```json
{
  "mcp.servers": {
    "Billing Management": {
      "url": "http://localhost:8005/mcp"
    }
  }
}
```


### Product Catalog

```json
{
  "mcp.servers": {
    "Product Catalog": {
      "url": "http://localhost:8006/mcp"
    }
  }
}
```


### Circuit Impairment And Maintenance

```json
{
  "mcp.servers": {
    "Circuit Impairment And Maintenance": {
      "url": "http://localhost:8007/mcp"
    }
  }
}
```


### Geographic Address Management

```json
{
  "mcp.servers": {
    "Geographic Address Management": {
      "url": "http://localhost:8008/mcp"
    }
  }
}
```


### Geographic Site Management

```json
{
  "mcp.servers": {
    "Geographic Site Management": {
      "url": "http://localhost:8009/mcp"
    }
  }
}
```


### Trouble Ticket Management

```json
{
  "mcp.servers": {
    "Trouble Ticket Management": {
      "url": "http://localhost:8010/mcp"
    }
  }
}
```


### Appointment Management

```json
{
  "mcp.servers": {
    "Appointment Management": {
      "url": "http://localhost:8011/mcp"
    }
  }
}
```


### Work Order Management

```json
{
  "mcp.servers": {
    "Work Order Management": {
      "url": "http://localhost:8012/mcp"
    }
  }
}
```



## Claude Desktop setup

Add an MCP server entry for each API that points at the running container.


### Product Offering Qualification

```json
{
  "mcpServers": {
    "Product Offering Qualification": {
      "url": "http://localhost:8000/mcp"
    }
  }
}
```


### Product Offering Availability And Pricing Discovery

```json
{
  "mcpServers": {
    "Product Offering Availability And Pricing Discovery": {
      "url": "http://localhost:8001/mcp"
    }
  }
}
```


### Quote

```json
{
  "mcpServers": {
    "Quote": {
      "url": "http://localhost:8002/mcp"
    }
  }
}
```


### Product Inventory

```json
{
  "mcpServers": {
    "Product Inventory": {
      "url": "http://localhost:8003/mcp"
    }
  }
}
```


### Product Order

```json
{
  "mcpServers": {
    "Product Order": {
      "url": "http://localhost:8004/mcp"
    }
  }
}
```


### Billing Management

```json
{
  "mcpServers": {
    "Billing Management": {
      "url": "http://localhost:8005/mcp"
    }
  }
}
```


### Product Catalog

```json
{
  "mcpServers": {
    "Product Catalog": {
      "url": "http://localhost:8006/mcp"
    }
  }
}
```


### Circuit Impairment And Maintenance

```json
{
  "mcpServers": {
    "Circuit Impairment And Maintenance": {
      "url": "http://localhost:8007/mcp"
    }
  }
}
```


### Geographic Address Management

```json
{
  "mcpServers": {
    "Geographic Address Management": {
      "url": "http://localhost:8008/mcp"
    }
  }
}
```


### Geographic Site Management

```json
{
  "mcpServers": {
    "Geographic Site Management": {
      "url": "http://localhost:8009/mcp"
    }
  }
}
```


### Trouble Ticket Management

```json
{
  "mcpServers": {
    "Trouble Ticket Management": {
      "url": "http://localhost:8010/mcp"
    }
  }
}
```


### Appointment Management

```json
{
  "mcpServers": {
    "Appointment Management": {
      "url": "http://localhost:8011/mcp"
    }
  }
}
```


### Work Order Management

```json
{
  "mcpServers": {
    "Work Order Management": {
      "url": "http://localhost:8012/mcp"
    }
  }
}
```


