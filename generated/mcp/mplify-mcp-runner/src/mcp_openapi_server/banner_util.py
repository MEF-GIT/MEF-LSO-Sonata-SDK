from rich.console import Console, Group
from rich.panel import Panel
from rich.align import Align
from rich.text import Text
from rich.table import Table

banner_text = r"""
███╗   ███╗██████╗ ██╗     ██╗███████╗██╗   ██╗
████╗ ████║██╔══██╗██║     ██║██╔════╝╚██╗ ██╔╝
██╔████╔██║██████╔╝██║     ██║█████╗   ╚████╔╝ 
██║╚██╔╝██║██╔═══╝ ██║     ██║██╔══╝    ╚██╔╝  
██║ ╚═╝ ██║██║     ███████╗██║██║        ██║   
╚═╝     ╚═╝╚═╝     ╚══════╝╚═╝╚═╝        ╚═╝   
                                               
███╗   ███╗ ██████╗██████╗                     
████╗ ████║██╔════╝██╔══██╗                    
██╔████╔██║██║     ██████╔╝                    
██║╚██╔╝██║██║     ██╔═══╝                     
██║ ╚═╝ ██║╚██████╗██║                         
╚═╝     ╚═╝ ╚═════╝╚═╝                         
"""

def print_banner(
    server_name: str,
    transport: str,
    listen_host: str,
    listen_port: int,
    openapi_uri: str,
) -> None:
    from importlib.metadata import version

    try:
        fastmcp_version = version("fastmcp")
    except Exception:
        fastmcp_version = "unknown"

    oas_name = openapi_uri.split("/")[-1]
    
    # Create the logo text with blue style
    logo_text = Text(banner_text, style="bold blue")
    
    # Create the information table
    info_table = Table.grid(padding=(0, 1))
    info_table.add_column(style="bold", justify="center")  # Emoji column
    info_table.add_column(style="cyan", justify="left")    # Label column
    info_table.add_column(style="dim", justify="left")     # Value column

    info_table.add_row("🖥", "Server name:", server_name)
    info_table.add_row("🚀", "FastMCP:", fastmcp_version)
    info_table.add_row("📦", "Transport:", transport.upper())
    
    if transport == "http":
        url = f"http://{listen_host}:{listen_port}/mcp"
        info_table.add_row("🔗", "Server URL:", url)
    elif transport == "sse":
        url = f"http://{listen_host}:{listen_port}/sse"
        info_table.add_row("🔗", "Server URL:", url)
        
    info_table.add_row("📄", "OAS File:", oas_name)

    panel_content = Group(
        Align.center(logo_text),
        "",
        Align.center(info_table),
    )

    panel = Panel(
        panel_content,
        border_style="blue",
        padding=(1, 4),
        expand=False,
    )

    Console().print(panel)