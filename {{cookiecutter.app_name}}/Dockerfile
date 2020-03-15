# Start with a base image containing Java runtime
FROM openjdk:15-jdk-slim

# Add Maintainer Info
LABEL maintainer="{{cookiecutter.maintainer}}"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/{{cookiecutter.app_name}}-{{cookiecutter.app_version}}.jar

# Add the application's jar to the container
ADD ${JAR_FILE} {{cookiecutter.app_name}}.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${PROFILE}","/{{cookiecutter.app_name}}.jar"]
