FROM openjdk:8
ADD target/DenDocConfigServer-0.0.1-SNAPSHOT.jar DenDocConfigServer-0.0.1-SNAPSHOT.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","DenDocConfigServer-0.0.1-SNAPSHOT.jar"]
#docker build -f Dockerfile -t docker-dendoc-config-server .
#docker run -p 8181:8181 docker-dendoc-config-server