# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/ems-backend-0.0.1-SNAPSHOT.jar /app/ems-backend-0.0.1-SNAPSHOT.jar

# Specify the port number the container should expose
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "ems-backend-0.0.1-SNAPSHOT.jar"]
