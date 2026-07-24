# Start from a Maven JDK image
FROM eclipse-temurin:17-jdk-alpine AS build

# Set working directory
WORKDIR /app

# Copy Maven wrapper and configuration
COPY mvnw .
COPY .mvn .mvn

# Make mvnw executable
RUN chmod +x mvnw

# Copy only pom.xml first to leverage Docker cache
COPY pom.xml .

# Download dependencies offline (cached)
RUN ./mvnw dependency:go-offline

# Now copy the source code
COPY src ./src

# Build the project (adjust the goal if needed)
RUN ./mvnw clean package -DskipTests

# ===== Optional: Create a lightweight runtime image =====
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]