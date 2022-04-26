# syntax=docker/dockerfile:1
FROM openjdk:11
WORKDIR /app
ADD /target/a-banking-card-service-0.0.1-SNAPSHOT.jar card-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "card-service.jar"]


