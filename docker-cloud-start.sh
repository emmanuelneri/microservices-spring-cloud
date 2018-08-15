#!/bin/bash

docker run -d \
    --name config-server \
    --network=spring-cloud \
    -p 8888:8888 \
    microservices-cloud/config

sleep 15

docker run -d \
    --name service-discovery \
    --network=spring-cloud \
    -p 8761:8761 \
    microservices-cloud/discovery

docker run -d \
    --name breaker \
    --network=spring-cloud \
    -p 7979:7979 \
    microservices-cloud/breaker

docker run -d \
    --name gateway \
    --network=spring-cloud \
    -p 8080:8080 \
    microservices-cloud/gateway

echo "Spring Cloud started"