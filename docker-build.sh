#!/bin/bash

mvn clean package
mvn -f config/pom.xml dockerfile:build
mvn -f discovery/pom.xml dockerfile:build
mvn -f breaker/pom.xml dockerfile:build
mvn -f gateway/pom.xml dockerfile:build
mvn -f receiver/pom.xml dockerfile:build
mvn -f processor/pom.xml dockerfile:build
mvn -f customers/pom.xml dockerfile:build
mvn -f files-api/pom.xml dockerfile:build
mvn -f orders-api/pom.xml dockerfile:build