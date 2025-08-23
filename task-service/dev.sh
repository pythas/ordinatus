#!/usr/bin/env bash
set -euo pipefail

PROFILE=dev

echo "Starting Postgres (docker compose)..."
docker compose up -d postgres pgadmin kafka zookeeper

echo "Running task-service with profile=$PROFILE..."
SPRING_PROFILES_ACTIVE=$PROFILE ./gradlew bootRun
