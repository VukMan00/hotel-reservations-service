FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8200
ADD target/*.jar hotel-reservation-microservice.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /hotel-reservation-microservice.jar" ]