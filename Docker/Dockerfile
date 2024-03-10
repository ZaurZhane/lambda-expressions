FROM openjdk:18-jdk-slim-buster

EXPOSE 8080

ADD target/AuthenticationApplication-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]