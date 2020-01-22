FROM openjdk:8
ADD target/DenDocRegistrationService-0.0.1-SNAPSHOT.jar DenDocRegistrationService-0.0.1-SNAPSHOT.jar
EXPOSE 8686
ENTRYPOINT ["java","-jar","DenDocRegistrationService-0.0.1-SNAPSHOT.jar"]

#docker build -f Dockerfile -t  docker-dendoc-registration-service .
#docker run -p 8686:8686 docker-dendoc-registration-service