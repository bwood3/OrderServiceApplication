FROM openjdk:17
COPY target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
