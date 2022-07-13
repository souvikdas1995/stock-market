FROM adoptopenjdk/openjdk11:alpine-jre
ADD authservice/target/authservice-0.0.1-SNAPSHOT-exec.jar authservice.jar
ENTRYPOINT ["java", "-jar","authservice.jar"]
EXPOSE 9191