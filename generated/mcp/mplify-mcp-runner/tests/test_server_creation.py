import unittest

from fastmcp import FastMCP
from fastmcp.server.providers.openapi import OpenAPIProvider

from mcp_openapi_server.server import ServerConfig, create_mcp_server


class CreateMcpServerTests(unittest.TestCase):
    def test_create_mcp_server_uses_openapi_provider(self) -> None:
        cfg = ServerConfig(
            openapi_spec={
                "openapi": "3.0.0",
                "info": {"title": "Petstore", "version": "1.0.0"},
                "paths": {},
            },
            server_uri="https://example.com",
            name="test-server",
            auth_mode="none",
        )

        mcp = create_mcp_server(cfg)

        self.assertIsInstance(mcp, FastMCP)
        self.assertEqual(mcp.name, "test-server")
        self.assertTrue(
            any(isinstance(provider, OpenAPIProvider) for provider in mcp.providers)
        )


if __name__ == "__main__":
    unittest.main()
