package com.dendoc.client.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dendoc.client.model.Client;
import com.dendoc.client.model.ClientSearchInfoModel;
import com.dendoc.client.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	
	@GetMapping("/client-service/getAllClients")
	@ApiOperation(value = "this is service used to get all clients")
	public ResponseEntity<List<Client>> getAllClients(){
		List<Client> clients= clientService.getAllClients();
		return new ResponseEntity<>(clients,HttpStatus.OK);
	}
	
	@GetMapping("/client-service/getAllClient/{clientId}")
	@ApiOperation(value = "this is service used to get all clients")
	public ResponseEntity<Client> getAllClient(
			@ApiParam(value = "clientId",required=true ) @PathVariable(value="clientId") long clientId ){
		Client clients= clientService.getAllClientById(clientId);
		return new ResponseEntity<>(clients,HttpStatus.OK);
	}
}
