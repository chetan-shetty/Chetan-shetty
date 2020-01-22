# DenDoc Backend Repo
Contains all the code base

Code Changes

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-sleuth</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-zipkin</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit</artifactId>
		</dependency>
		

Add the below code in main class(add this code to service and zuul/api gateway)

import org.springframework.context.annotation.Bean;
import brave.sampler.Sampler;

	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}


Rabait MQ Installation
https://www.rabbitmq.com/
Install rabit mq

https://www.erlang.org/downloads
install this - it has dependency on rabit mq

Set the environment variable as RABBITMQ_BASE=c:\rabbitmq

remove the existing service by running -

open cmd is administrator
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.1\sbin>rabbitmq-service.bat remove

C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.1\sbin>rabbitmq-service.bat install (make sure disconnected from VPN)


C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.1\sbin>rabbitmq-server.bat

################################################################################################
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.1\sbin>rabbitmq-server.bat

  ##  ##      RabbitMQ 3.8.1
  ##  ##
  ##########  Copyright (c) 2007-2019 Pivotal Software, Inc.
  ######  ##
  ##########  Licensed under the MPL 1.1. Website: https://rabbitmq.com

  Doc guides: https://rabbitmq.com/documentation.html
  Support:    https://rabbitmq.com/contact.html
  Tutorials:  https://rabbitmq.com/getstarted.html
  Monitoring: https://rabbitmq.com/monitoring.html

  Logs: c:/rabbitmq/log/rabbit@ELW3307.log
        c:/rabbitmq/log/rabbit@ELW3307_upgrade.log

  Config file(s): (none)

  Starting broker... completed with 0 plugins.
################################################################################################


Zipkin Installation

https://zipkin.io/pages/quickstart

# get the latest source
git clone https://github.com/openzipkin/zipkin
cd zipkin
# Build the server and also make its dependencies
./mvnw -DskipTests --also-make -pl zipkin-server clean install
# Run the server
java -jar ./zipkin-server/target/zipkin-server-*exec.jar


SET RABBIT_URI=amqp://localhost 
C:\DevStuff\ZipkinServerDocker\zipkin\zipkin-server\target>java -jar zipkin-server-2.19.3-SNAPSHOT-exec.jar


http://127.0.0.1:9411/zipkin/



1. Register Server
2. Config Server
3. Zuul API Gateway
4. REST Services
5. MQ
7. Zipkin


#Mysql Command
C:\Program Files\MySQL\MySQL Swever 5.7\bin> musql -u root -p dendoc_dev
C:\Program Files\MySQL\MySQL Swever 5.7\bin> ALTER USER 'root'@'%' IDENTIFIED BY 'root@1234';


