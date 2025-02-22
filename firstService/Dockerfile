FROM openjdk:17-oracle
LABEL authors="alper"
ENV KafkaAddr=${KafkaAddr}
COPY target/First-Service.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]