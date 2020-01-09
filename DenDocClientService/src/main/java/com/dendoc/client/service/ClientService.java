package com.dendoc.client.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dendoc.client.model.ClientSearchInfoModel;

@Service
public class ClientService {
	
	Logger logger = Logger.getLogger(ClientService.class.getName());
	
	@Autowired
	ClientServiceProxy clientServiceProxy;
	
	@Value("${server.port}")
	private int port;
	
	public ClientSearchInfoModel getClientSearchInfo(){
		ClientSearchInfoModel clientSearchInfoModel = new ClientSearchInfoModel();
		clientSearchInfoModel.setServicesList(clientServiceProxy.getServices());
		clientSearchInfoModel.setInsurancesList(clientServiceProxy.getInsurances());
		return clientSearchInfoModel;
	}
}
