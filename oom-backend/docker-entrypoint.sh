#!/bin/bash
set -e

#update-ca-certificates -v
java \
-Dspring.datasource.url=$DB_URL \
-Dspring.datasource.username=$DB_USER \
-Dspring.datasource.password=$DB_PASSWORD \
-jar /app.jar

exec "$@"