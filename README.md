# out-of-memory

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c8469c7c14f344c9a6bb27e6692db748)](https://app.codacy.com/gh/Out-Of-Memory-Team/out-of-memory?utm_source=github.com&utm_medium=referral&utm_content=Out-Of-Memory-Team/out-of-memory&utm_campaign=Badge_Grade_Settings)
[![Backend CI](https://github.com/Out-Of-Memory-Team/out-of-memory/actions/workflows/java-ci.yml/badge.svg?branch=master)](https://github.com/Out-Of-Memory-Team/out-of-memory/actions/workflows/java-ci.yml)
[![Frontend CI](https://github.com/Out-Of-Memory-Team/out-of-memory/actions/workflows/node-ci.yml/badge.svg?branch=master)](https://github.com/Out-Of-Memory-Team/out-of-memory/actions/workflows/node-ci.yml)

Welcome to our project!

Contributors: Luca, Leonhard, Franz, Justin

## Prerequisites
- Maven
- Node 12.X
- Docker
- Docker-Compose

## Run `master`-version

Run application:
1) Run `docker-compose -f docker-compose.postgresql.yml -f docker-compose.deploy.yml up -d`

Done! The frontend is running at http://localhost/.

## Build your own version

Before going through the steps you have to clone this repository!

Build backend image:
1) Navigate to `/oom-backend`
2) Run `mvn install` to build the backend
3) Run `docker build . -t oom-backend` to build the Dockerfile

Build frontend image:
1) Navigate to `/oom-frontend`
2) Run `npm ci` to install the dependencies
3) Run `npm run build` to build the frontend
4) Run `docker build . -t oom-frontend` to build the Dockerfile

Run application:
1) Navigate to `/`
2) Run `docker-compose -f docker-compose.postgresql.yml -f docker-compose.dev.yml up -d`

Done! The frontend is running at http://localhost/.
