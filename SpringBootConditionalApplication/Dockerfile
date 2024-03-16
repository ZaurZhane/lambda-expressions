FROM openjdk:18-jdk-slim-buster
EXPOSE 8081
ADD target/SpringBootConditionalApplication-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]