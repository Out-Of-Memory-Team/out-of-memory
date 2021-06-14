#!/bin/bash
set -e

#update-ca-certificates -v
java -jar /app.jar

exec "$@"