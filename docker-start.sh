#!/bin/bash

docker network create spring-cloud

docker run -d \
    --name config-server \
    --network=spring-cloud \
    -p 8888:8888 \
    microservices-cloud/config

echo "Waiting Config Server..."
## TODO melhorar - verificar host disponível
sleep 30

docker-compose up