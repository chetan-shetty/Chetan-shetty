package com.dendoc.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableConfigServer
@SpringBootApplication
public class DenDocConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DenDocConfigServerApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}

}
