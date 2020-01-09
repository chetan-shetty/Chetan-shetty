package com.dendoc.provider.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.dendoc.provider.config.Configuration;
import com.dendoc.provider.dao.InsuranceRepository;
import com.dendoc.provider.dao.ProviderRepository;
import com.dendoc.provider.dao.ServiceRepository;
import com.dendoc.provider.exception.CustomException;
import com.dendoc.provider.model.Insurance;
import com.dendoc.provider.model.Provider;

@Service
public class ProviderService {
	
	Logger logger = Logger.getLogger(ProviderService.class.getName());
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	Configuration config;

	
	@Value("${server.port}")
	private int port;
	
	public List<com.dendoc.provider.model.Service> getServices() {
		List<com.dendoc.provider.model.Service> services = serviceRepository.getServices();
		if(services != null) {
			return services;
		}else {
			String errorMessage = "There are not Services available";
			logger.log(Level.WARNING, errorMessage);
			throw new CustomException(errorMessage);
		}
	}
	
	public List<Insurance> getInsurances() {
		List<Insurance> insurance = insuranceRepository.getInsurances();
		if(insurance != null) {
			return insurance;
		}else {
			String errorMessage = "There are not Insurances available";
			logger.log(Level.WARNING, errorMessage);
			throw new CustomException(errorMessage);
		}
	}
	
	//@PutMapping("{id}")
	public Provider updateProvider(Long id, Provider provider) {
		logger.log(Level.INFO, "Inside updateProvider {}",provider.toString());
		Provider providerToUpdate = providerRepository.findById(id).
				orElseThrow(()->new CustomException("Provider not found"));
	 
	        providerToUpdate.setProviderName((provider.getProviderName()!=null) ? provider.getProviderName() : providerToUpdate.getProviderName());
	        providerToUpdate.setPhoneNumber(provider.getPhoneNumber()!=null ? provider.getPhoneNumber() : providerToUpdate.getPhoneNumber());
	        providerToUpdate.setEmail(provider.getEmail() !=null ? provider.getEmail() : providerToUpdate.getEmail());
		
	    logger.log(Level.INFO, "Provider details Before updating into DB : {}",providerToUpdate.toString());
	    return providerRepository.save(providerToUpdate);
	} 
	
	public Provider insertProvider(Provider provider) {
		logger.log(Level.INFO, "Inside insertProvider {}",provider.toString());
		return providerRepository.save(provider);
	} 
	
	public Provider getProviderById(Long id) {
		logger.log(Level.INFO, "Inside getProviderById {}",id);
	    return providerRepository.findById(id).orElseThrow(()->new CustomException("Provider not found"));
	}  
	
	public List<Provider> getAllProviders() {
		logger.log(Level.INFO, "Inside getAllProviders");
	    return providerRepository.findAll();
	} 
	
	public void deleteProvider(Long id) {

		logger.log(Level.INFO, "Inside deleteProvider {} ",id);
		providerRepository.findById(id).orElseThrow(()->new CustomException("Provider not found"));
		providerRepository.deleteById(id);
	}
}
