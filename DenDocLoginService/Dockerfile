FROM openjdk:8
ADD target/DenDocLoginService-0.0.1-SNAPSHOT.jar DenDocLoginService-0.0.1-SNAPSHOT.jar
EXPOSE 8685
ENTRYPOINT ["java","-jar","DenDocLoginService-0.0.1-SNAPSHOT.jar"]

#docker build -f Dockerfile -t  docker-dendoc-login-service .
#docker run -p 8685:8685 docker-dendoc-login-service