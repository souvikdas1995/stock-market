FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/*.jar myapplication
ENTRYPOINT ["java", "-jar","myapplication"]
EXPOSE 8081