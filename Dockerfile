FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

COPY . .

RUN ./gradlew clean build

# Copy your compiled Java application JAR file
COPY ./build/libs/postgres-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
#EXPOSE 5432

# Define the entry point to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
