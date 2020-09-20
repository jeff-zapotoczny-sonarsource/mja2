#!/bin/bash

# Load common environment

echo "Running analysis"
mvn clean verify sonar:sonar -Dsonar.host.url=$SQ_URL -Dsonar.login=$SQ_TOKEN \
   -Dsonar.security.sources.javasecurity.S2076=customSecurityConfig.json \
   -Dsonar.security.sanitizers.javasecurity.S2076=customSecurityConfig.json \
   -Dsonar.security.passthroughs.javasecurity.S2076=customSecurityConfig.json \
   -Dsonar.security.sinks.javasecurity.S2076=customSecurityConfig.json
