#!/bin/bash

docker network create spring-cloud

docker run -d \
    --name config-server \
    --network=spring-cloud \
    -p 8888:8888 \
    microservices-cloud/config

docker run -d \
  --name orders-db-master \
  --network=spring-cloud \
  -e POSTGRESQL_REPLICATION_MODE=master \
  -e POSTGRESQL_USERNAME=postgres \
  -e POSTGRESQL_PASSWORD=postgres \
  -e POSTGRESQL_DATABASE=orders \
  -e POSTGRESQL_REPLICATION_USER=replication \
  -e POSTGRESQL_REPLICATION_PASSWORD=postgres \
  bitnami/postgresql:9.6

docker run -d \
  --name orders-db-slave \
  --network=spring-cloud \
  --link orders-db-master \
  -e POSTGRESQL_REPLICATION_MODE=slave \
  -e POSTGRESQL_MASTER_HOST=orders-db-master \
  -e POSTGRESQL_MASTER_PORT_NUMBER=5432 \
  -e POSTGRESQL_REPLICATION_USER=postgres \
  -e POSTGRESQL_REPLICATION_PASSWORD=postgres \
  bitnami/postgresql:9.6

docker run -d \
    --name customers-db \
    --network=spring-cloud \
    -p 5432:5432 \
    -e POSTGRES_DB=customers \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    postgres:9.6

docker run -d \
    --name cache \
    --network=spring-cloud \
    -p 6379:6379 \
    redis:4.0.8

docker run -d \
    --name file-db \
    --network=spring-cloud \
    -p 27017:27017 \
    mongo:3.5

docker run -d \
    --name queue \
    --network=spring-cloud \
    -p 5672:5672 \
    -p 15672:15672 \
    rabbitmq:management


echo "Infra started"