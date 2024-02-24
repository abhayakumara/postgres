FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy your compiled Java application JAR file
COPY ./build/libs/postgres-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Define the entry point to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
