# Use a base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file to the container
COPY target/simple-spring-boot-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "/app/app.jar"]
