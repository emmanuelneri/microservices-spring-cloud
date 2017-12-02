#!/bin/bash

mvn clean package
mvn -f config/pom.xml dockerfile:build
mvn -f discovery/pom.xml dockerfile:build
mvn -f receiver/pom.xml dockerfile:build
mvn -f processor/pom.xml dockerfile:build
mvn -f api/pom.xml dockerfile:build