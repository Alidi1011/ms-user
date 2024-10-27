FROM openjdk:17
WORKDIR /app
COPY ./target/ms-user-0.0.1-SNAPSHOT.jar .
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "ms-user-0.0.1-SNAPSHOT.jar"]