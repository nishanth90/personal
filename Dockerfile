FROM openjdk:8-jdk-alpine
RUN apk update && apk add bash
RUN mkdir /app
ADD target/transactiondataexporter*.jar /app/app.jar
WORKDIR /app
RUN chmod -R 0777 /app
ENTRYPOINT ["java", "-jar", "app.jar"]