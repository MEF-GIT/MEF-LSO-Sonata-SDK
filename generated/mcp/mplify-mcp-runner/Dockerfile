
FROM python:3.11-slim

WORKDIR /app

# Keep image small + predictable
ENV PYTHONDONTWRITEBYTECODE=1 \
    PYTHONUNBUFFERED=1 \
    PIP_DISABLE_PIP_VERSION_CHECK=1 \
    PIP_NO_CACHE_DIR=1

# Default listen settings (override with env)
ENV MCP_LISTEN_HOST=0.0.0.0 \
    MCP_LISTEN_PORT=8000

COPY pyproject.toml README.md /app/
COPY src /app/src

RUN pip install --no-cache-dir -U pip \
    && pip install --no-cache-dir .

EXPOSE 8000

ENTRYPOINT ["mplify-mcp-server"]
