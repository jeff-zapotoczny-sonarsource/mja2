#!/bin/bash

# Load common environment

echo "Running analysis"
mvn clean verify sonar:sonar -Dsonar.host.url=$SQ_URL -Dsonar.login=$SQ_TOKEN
