# Use a base image with OpenJDK 17
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy any JAR file from the target directory to the app directory
COPY /target/*.jar /app/app.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "/app/app.jar"]
