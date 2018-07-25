# Sample Dockerfile for use with the Docker file mode
FROM ${base}

ENV SAMPLE_BUILD_MODE=dockerfile
LABEL PROJECT_NAME=hello-world \
      PROJECT=${project.artifactId}

# Arbitrary files can be added
ADD ${project.artifactId}-${project.version}.jar /

# In maven/ the files as specified in the <assembly> section is stored
# and need to be added manually
COPY maven/ /var/lib/jetty/webapps/

EXPOSE 8080


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/${project.artifactId}-${project.version}.jar"]



docker build -t blog/sbdemo:latest .


docker run -d --name demo-default -p 8090:8090 -p 8091:8091 blog/sbdemo:latest






//look at this tomorrow....

# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
# copy application WAR (with libraries inside)
COPY target/spring-boot-*.war /app.war
# specify default command
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.war"]