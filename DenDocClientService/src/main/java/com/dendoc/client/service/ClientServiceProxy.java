package com.dendoc.client.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.dendoc.client.model.Insurance;
import com.dendoc.client.model.Service;

@FeignClient(name="ZUUL-SERVER")
public interface ClientServiceProxy {
	
	@GetMapping("/provider-service/provider-service/getServices")
	public List<Service> getServices();
	
	@GetMapping("/provider-service/provider-service/getInsurances")
	public List<Insurance> getInsurances();
	
}
