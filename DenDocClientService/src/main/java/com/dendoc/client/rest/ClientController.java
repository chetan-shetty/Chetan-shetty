package com.dendoc.client.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dendoc.client.model.ClientSearchInfoModel;
import com.dendoc.client.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Client Service")
@FeignClient(name="ZUUL-SERVER")
public class ClientController {
	
	Logger logger = Logger.getLogger(ClientController.class.getName());

	@Autowired
	ClientService clientService;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/client-service/getClientSearchInfo")
	@ApiOperation(value = "this is service used to get services, insurance providers for search")
	public ResponseEntity<ClientSearchInfoModel> getClientSearchInfo(){
		ClientSearchInfoModel clientSearchInfo = clientService.getClientSearchInfo();
		return new ResponseEntity<>(clientSearchInfo,HttpStatus.OK);
	}
}
