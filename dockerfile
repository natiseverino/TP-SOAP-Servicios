FROM openjdk:8-jdk-alpine

EXPOSE 8080
#The application's jar file
ARG JAR_FILE=target/soap.example-0.0.1-SANPSHOT.jar
·add the application's jar to the container
ADD ${JAR_FILE} soapr.example.jar
CMD ["java","-jar","/soap.example.jar"]
