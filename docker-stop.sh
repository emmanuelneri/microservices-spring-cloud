#!/bin/bash

docker-compose rm -f
docker rm -f config-server
docker network rm spring-cloud
