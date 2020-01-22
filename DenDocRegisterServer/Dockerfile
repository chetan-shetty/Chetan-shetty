FROM openjdk:8
ADD target/DenDocRegisterServer-0.0.1-SNAPSHOT.jar DenDocRegisterServer-0.0.1-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","DenDocRegisterServer-0.0.1-SNAPSHOT.jar"]
#docker build -f Dockerfile -t docker-dendoc-register-server .
#docker run -p 8761:8761 docker-dendoc-register-server
