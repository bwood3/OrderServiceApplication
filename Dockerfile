# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -f pom.xml clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17
COPY --from=build /app/target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
