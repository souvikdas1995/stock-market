FROM adoptopenjdk/openjdk11:alpine-jre
ADD api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java", "-jar","api-gateway.jar"]
EXPOSE 8083