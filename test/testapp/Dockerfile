# Start with a base image containing Java runtime
FROM openjdk:15-jdk-slim

# Add Maintainer Info
LABEL maintainer="Daniel Brackin"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/testapp-0.0.1.jar

# Add the application's jar to the container
ADD ${JAR_FILE} testapp.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${PROFILE}","/testapp.jar"]
