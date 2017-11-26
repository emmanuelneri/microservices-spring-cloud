#!/bin/bash

mvn clean package
mvn -f config/pom.xml dockerfile:build
mvn -f discovery/pom.xml dockerfile:build
mvn -f leitor/pom.xml dockerfile:build
mvn -f processador/pom.xml dockerfile:build
mvn -f disponibilizador/pom.xml dockerfile:build