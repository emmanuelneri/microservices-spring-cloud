FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/config-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]