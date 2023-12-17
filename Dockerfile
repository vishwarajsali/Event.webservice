#FROM openjdk:17 AS buildstage
#LABEL maintainer="vishsali.dev"
#EXPOSE 8080
#ADD target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]


FROM openjdk:17 AS Build
VOLUME /tmp
EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/*.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]


#docker build ./ -t event-webservice