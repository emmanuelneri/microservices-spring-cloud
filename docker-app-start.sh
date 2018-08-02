#!/bin/bash

docker run -itd \
    --name receiver-app \
    --network=spring-cloud \
    -p 8090:8090 \
    microservices-cloud/receiver-app

docker run -itd \
    --name customers-app \
    --network=spring-cloud \
    -p 8060:8060 \
    microservices-cloud/customers-app

docker run -itd \
    --name processor-app \
    --network=spring-cloud \
    -p 8081:8081 \
    microservices-cloud/processor-app

docker run -itd \
    --name files-api-app \
    --network=spring-cloud \
    -p 8070:8070 \
    microservices-cloud/files-api-app

docker run -itd \
    --name orders-api-app \
    --network=spring-cloud \
    -p 8050:8050 \
    microservices-cloud/orders-api-app
