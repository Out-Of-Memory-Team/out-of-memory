FROM openjdk:11-jre

# Make port 80 and 443 available to the world outside this container
EXPOSE 80 443

#HEALTHCHECK --interval=30s --timeout=3s CMD curl --fail https://localhost:443 || exit 1

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/oom-backend-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar
COPY ./docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh


# Start app
ENTRYPOINT ["/docker-entrypoint.sh"]
