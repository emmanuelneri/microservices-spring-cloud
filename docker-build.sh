#!/bin/bash

mvn clean install
mvn -f config/pom.xml docker:build
mvn -f discovery/pom.xml docker:build
mvn -f breaker/pom.xml docker:build
mvn -f gateway/pom.xml docker:build
mvn -f receiver/pom.xml docker:build
mvn -f processor/pom.xml docker:build
mvn -f customers/pom.xml docker:build
mvn -f files-api/pom.xml docker:build
mvn -f orders-api/pom.xml docker:build

#(cd web && ng build --output-path=build)
#(cd web && docker build -t microservices-cloud/web .)