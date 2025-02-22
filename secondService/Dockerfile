FROM openjdk:17-oracle
LABEL authors="Alper"
COPY target/Second-Service.jar app.jar
ENV KafkaAddr=${KafkaAddr}
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]