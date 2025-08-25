
#!/usr/bin/env bash
set -euo pipefail

COMPOSE_FILE=${COMPOSE_FILE:-.docker/compose.yml}

echo "Stopping Kafka and Zookeeper..."
docker compose -f "$COMPOSE_FILE" stop kafka zookeeper

echo "Removing Kafka & Zookeeper containers..."
docker compose -f "$COMPOSE_FILE" rm -f -s kafka zookeeper || true

echo "Removing Kafka volumes..."
docker volume rm docker_kafka_data || true
docker volume rm docker_zookeeper_data || true

echo "Starting Kafka and Zookeeper..."
docker compose -f "$COMPOSE_FILE" up -d kafka zookeeper

echo "✅ Kafka has been reset"
