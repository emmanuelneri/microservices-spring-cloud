#!/bin/bash

docker-compose rm -f
docker rm -f config-server
docker rm -f orders-db-master
docker rm -f orders-db-slave
docker rm -f customers-db
docker rm -f cache
docker rm -f file-db
docker rm -f queue
docker rm -f config-server
docker rm -f service-discovery
docker rm -f breaker
docker rm -f gateway
docker rm -f trace
docker network rm spring-cloud
