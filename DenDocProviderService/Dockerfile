FROM openjdk:8
ADD target/DenDocProviderService-0.0.1-SNAPSHOT.jar DenDocProviderService-0.0.1-SNAPSHOT.jar
EXPOSE 8687
ENTRYPOINT ["java","-jar","DenDocProviderService-0.0.1-SNAPSHOT.jar"]

#docker build -f Dockerfile -t  docker-dendoc-provider-service .
#docker run -p 8687:8687 docker-dendoc-provider-service