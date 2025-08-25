#!/usr/bin/env bash
set -euo pipefail

COMPOSE_FILE=${COMPOSE_FILE:-.docker/compose.yml}

echo "Starting docker infra..."
docker compose -f "$COMPOSE_FILE" up -d postgres pgadmin kafka zookeeper