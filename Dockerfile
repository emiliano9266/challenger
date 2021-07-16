FROM maven:3.8.1-openjdk-11 AS builder
WORKDIR /compile/
COPY . /compile
RUN mvn test
RUN mvn package

FROM openjdk:11.0-oracle as runtime
COPY --from=builder /compile/target/*.jar /demo/app.jar
EXPOSE 7777
ENTRYPOINT ["java","-jar","/demo/app.jar"]