FROM openjdk:8
ADD target/DenDocClientService-0.0.1-SNAPSHOT.jar DenDocClientService-0.0.1-SNAPSHOT.jar
EXPOSE 8688
ENTRYPOINT ["java","-jar","DenDocClientService-0.0.1-SNAPSHOT.jar"]

#docker build -f Dockerfile -t  docker-dendoc-client-service .
#docker run -p 8688:8688 docker-dendoc-client-service