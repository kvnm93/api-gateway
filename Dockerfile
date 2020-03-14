FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/api-gateway-1.0-SNAPSHOT-exec.jar .
ENTRYPOINT ["java","-jar","/api-gateway-1.0-SNAPSHOT-exec.jar"]