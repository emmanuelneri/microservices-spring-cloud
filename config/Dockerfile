FROM openjdk:8-jdk-alpine
VOLUME /tmp

COPY jce_policy-8.zip /tmp/jce_policy-8.zip
RUN apk upgrade --update && \
    apk add --update unzip && \
    unzip -jo -d ${JAVA_HOME}/jre/lib/security /tmp/jce_policy-8.zip && \
    apk del unzip && \
    rm -rf /tmp/* /var/cache/apk/*

ADD target/config-1.0-SNAPSHOT.jar app.jar
ADD config-repo /tmp/config-repo
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=native -Dspring.cloud.config.server.native.search-locations=file:///tmp/config-repo /app.jar" ]