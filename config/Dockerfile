FROM openjdk:14.0-slim
VOLUME /tmp

ADD target/config-1.0-SNAPSHOT.jar app.jar
ADD config-repo /tmp/config-repo
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=native -Dspring.cloud.config.server.native.search-locations=file:///tmp/config-repo /app.jar" ]