package com.dendoc.provider.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dendoc.provider.model.Insurance;
import com.dendoc.provider.model.Provider;
import com.dendoc.provider.model.Service;
import com.dendoc.provider.service.ProviderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Provider Service")
@FeignClient(name="ZUUL-SERVER")
public class ProviderController {
	
	Logger logger = Logger.getLogger(ProviderController.class.getName());

	@Autowired
	ProviderService providerService;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/provider-service/getServices")
	@ApiOperation(value = "this is to get all services provided")
	public ResponseEntity<List<Service>> getServices(){
		List<Service> services = providerService.getServices();
		return new ResponseEntity<>(services,HttpStatus.OK);
	}
	
	@GetMapping("/provider-service/getInsurances")
	@ApiOperation(value = "this is to get all insurance provided")
	public ResponseEntity<List<Insurance>> getInsurances(){
		List<Insurance> insurance = providerService.getInsurances();
		return new ResponseEntity<>(insurance,HttpStatus.OK);
	}
	
	@PostMapping("/provider-service/updateProvider")
	@ApiOperation(value = "this is to Update provider details")
	public ResponseEntity<Provider> updateProvider(@RequestBody Provider inputProvider){
		Provider provider = providerService.updateProvider(inputProvider.getProviderId(), inputProvider);
		return new ResponseEntity<>(provider,HttpStatus.OK);
	}
	
	@PostMapping("/provider-service/insertProvider" )
	@ApiOperation(value = "this is to Insert new provider details")
	public ResponseEntity<Provider> insertProvider(@RequestBody Provider inputProvider){
		Provider provider = providerService.insertProvider(inputProvider);
		return new ResponseEntity<>(provider,HttpStatus.OK);
	}
	
	@GetMapping("/provider-service/getProviderById/{providerId}")
	@ApiOperation(value = "this is to get provider details based on providerId")
	public ResponseEntity<Provider> getProviderById(@PathVariable(value="providerId") long providerId){
		Provider provider = providerService.getProviderById(providerId);
		return new ResponseEntity<>(provider,HttpStatus.OK);
	}
	
	@GetMapping("/provider-service/getProvider")
	@ApiOperation(value = "this is to get all provider details")
	public ResponseEntity<List<Provider>> getProvider(){
		List<Provider> provider = providerService.getAllProviders();
		return new ResponseEntity<>(provider,HttpStatus.OK);
	}
	
	@DeleteMapping("/provider-service/deleteProvider/{providerId}")
	@ApiOperation(value = "this is to delete provider details based on providerId")
	public ResponseEntity<Void> deleteProvider(@PathVariable(value="providerId") long providerId){
		 providerService.deleteProvider(providerId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
