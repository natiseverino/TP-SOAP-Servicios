FROM openjdk:8-jdk-alpine

EXPOSE 8080

#The application's jar file
ARG JAR_FILE=target/servicios.soap-0.0.1-SNAPSHOT.jar

#add the application's jar to the container
ADD ${JAR_FILE} servicios.soap.jar

CMD ["java","-jar","/servicios.soap.jar"]
