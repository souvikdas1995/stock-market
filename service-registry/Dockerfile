FROM adoptopenjdk/openjdk11:alpine-jre
ADD service-registry/target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
ENTRYPOINT ["java", "-jar","service-registry.jar"]
EXPOSE 8761