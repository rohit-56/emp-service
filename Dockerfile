FROM eclipse-temurin:21

LABEL mentainer = "rohitshm25@gmail.com"

WORKDIR /app

COPY target/employee-0.0.1-SNAPSHOT.jar /app/employee-docker-image.jar


ENTRYPOINT ["java","-jar","employee-docker-image.jar"]