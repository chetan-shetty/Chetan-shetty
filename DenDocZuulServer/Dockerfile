FROM openjdk:8
ADD target/DenDocZuulServer-0.0.1-SNAPSHOT.jar DenDocZuulServer-0.0.1-SNAPSHOT.jar
EXPOSE 8787
ENTRYPOINT ["java","-jar","DenDocZuulServer-0.0.1-SNAPSHOT.jar"]

#docker build -f Dockerfile -t  docker-dendoc-zuul-gateway .
#docker run -p 8787:8787 docker-dendoc-zuul-gateway