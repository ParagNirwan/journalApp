# Journal App

A Spring Boot backend project for a journal application, using MongoDB for persistence and Spring Security for authentication and authorization experiments.

## Tech stack

- Java 8
- Spring Boot 2.7
- Spring Web
- Spring Data MongoDB
- Spring Security
- Maven

## Prerequisites

- JDK 8
- Maven
- MongoDB running locally or remotely

## Run locally

1. Configure the MongoDB connection and security-related settings for your environment. Do not commit credentials.
2. Start the application from the repository root:

   ```bash
   mvn spring-boot:run
   ```

3. By default, Spring Boot uses port 8080 unless the application configuration overrides it.

## Build and test

```bash
mvn test
mvn package
```

## Project status

This is a learning project, not a production-ready journal service. It uses Spring Boot 2.7, an older release line. A production-oriented follow-up would upgrade Spring Boot and Java, add integration tests for authentication and journal ownership, and ensure secrets are supplied through environment configuration.