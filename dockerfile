# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Add Maintainer Info
LABEL maintainer="joseantonio.debenito@alsa.es"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 1212 available to the world outside this container
EXPOSE 5000

# The application's jar file
ARG JAR_FILE=target/backendPrueba-*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} backendPrueba-*.jar

ENV TZ=Europe/Madrid
RUN apk add tzdata
RUN cd /usr/share/zoneinfo
RUN cp /usr/share/zoneinfo/$TZ /etc/localtime

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/backendPrueba-*.jar"]