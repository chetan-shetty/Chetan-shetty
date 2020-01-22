package com.dendoc.client.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dendoc.client.dao.ClientRepository;
import com.dendoc.client.model.Client;
import com.dendoc.client.model.ClientSearchInfoModel;
import com.dendoc.client.exception.CustomException;

@Service
public class ClientService {
	
	Logger logger = Logger.getLogger(ClientService.class.getName());
	
	@Autowired
	ClientServiceProxy clientServiceProxy;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Value("${server.port}")
	private int port;
	
	public ClientSearchInfoModel getClientSearchInfo(){
		ClientSearchInfoModel clientSearchInfoModel = new ClientSearchInfoModel();
		clientSearchInfoModel.setServicesList(clientServiceProxy.getServices());
		clientSearchInfoModel.setInsurancesList(clientServiceProxy.getInsurances());
		return clientSearchInfoModel;
	}
	
	public List<Client> getAllClients() {
		logger.log(Level.INFO, "Inside getAllClients");
	    return clientRepository.findAll();
	} 
	
	public Client getAllClientById(long id) {
		logger.log(Level.INFO, "Inside getAllClients");
	    return clientRepository.findById(id).orElseThrow(()->new CustomException("Client not found"));
	} 
	
	public Client updateProvider(Long id, Client client) {
		logger.info("Inside updateProvider "+client.toString());
		Client ClientToUpdate = clientRepository.findById(id).
				orElseThrow(()->new CustomException("Client not found"));
	 
		ClientToUpdate =client;
	    logger.info( "Client details Before updating into DB : "+client.toString());
	    return  clientRepository.save(ClientToUpdate);
	} 
	
	public Client insertClient(Client client) {
		logger.log(Level.INFO, "Inside insertClient {}",client.toString());
		logger.info("Inside insertClient "+client.toString());
		//logger.info("Inside insertClient {}",Client.toString());
		return clientRepository.save(client);
	} 
}
