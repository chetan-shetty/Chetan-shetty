package com.dendoc.registration.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dendoc.registration.config.Configuration;
import com.dendoc.registration.dao.RegistrationRepository;
import com.dendoc.registration.exception.UserExisitException;
import com.dendoc.registration.exception.UserNotFoundException;
import com.dendoc.registration.model.UserProvider;
import com.dendoc.registration.model.Users;
import com.dendoc.registration.rest.RegistrationController;

@Service
public class RegistrationService {
	
	Logger logger = Logger.getLogger(RegistrationService.class.getName());
	
	@Autowired
	RegistrationRepository regRepository;
	
	@Autowired
	Configuration config;

	
	/*
	 * @Autowired(required=true) RegistrationServiceProxy registrationServiceProxy;
	 */
	 
	
	@Value("${server.port}")
	private int port;
	
	public Users registerUser(Users users) {
		//if(config.getLocation().equals("landon")) {
			String loginName = regRepository.isUserExisit(users.getLoginName());
			if(loginName == null) {
				regRepository.save(users);
			}else {
				logger.log(Level.WARNING, "Users already registered - "+users.getLoginName());
				throw new UserExisitException(loginName);
			}
		//}
		return users;
	}

	public boolean verifyLoginName(String loginName) {
		String status = regRepository.isUserExisit(loginName);
		if(status != null) {
			return true;
		}else {
			logger.log(Level.WARNING, "Login name not found - "+loginName);
			return false;
		}
	}

	public Users getUserByLoginName(String loginName) {
		Users users = regRepository.getUserByLoginName(loginName);
		if(users != null) {
			return users;
		}else {
			logger.log(Level.WARNING, "Users not found - "+loginName);
			throw new UserNotFoundException(loginName);
		}
	}
	
	/*
	 * public boolean insertUserPRovider(UserProvider userProvider) {
	 * 
	 * boolean val = registrationServiceProxy.insertLoginProvider(userProvider);
	 * logger.info("insertUserPRovider  "+val); return val; }
	 */
}
