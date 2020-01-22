package com.dendoc.login.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dendoc.login.exception.LoginFailedException;
import com.dendoc.login.model.Login;
import com.dendoc.login.model.UserProvider;
import com.dendoc.login.model.Users;

@Service
public class LoginService {
	
	Logger logger = Logger.getLogger(LoginService.class.getName());
	
	
	@Autowired
	UserServiceProxy userServiceProxy;

	/*
	 * @Autowired RegistrationServiceProxy registrationServiceProxy;
	 */
	
	@Value("${server.port}")
	private int port;
	
	public Login validateUser(Login login) {
		
		boolean status = userServiceProxy.verifyLoginName(login.getLoginName());
		
		if(status) {
			Users user = userServiceProxy.getUserByLoginName(login.getLoginName());
			if(user != null) {
				if(user.getLoginName().equals(login.getLoginName()) && user.getloginPassword().equals(login.getPassword())) {
					return login;
				}else {
					logger.log(Level.WARNING, "User validation failed for - "+login.getLoginName());
					throw new LoginFailedException(login.getLoginName());
				}
				
			}else {
				logger.log(Level.WARNING, "User not found for - "+login.getLoginName());
				throw new LoginFailedException(login.getLoginName());
			}
		}else {
			throw new LoginFailedException(login.getLoginName());
		}
	}
	
	public Users registerUser(Users user) {
		
		logger.info("registerUseruserServiceProxy  "+user.toString());
		return userServiceProxy.registerUser(user);
		
	}
	
	public boolean insertUserPRovider(UserProvider userProvider) {
		
		boolean val = userServiceProxy.insertLoginProvider(userProvider);
		logger.info("insertUserPRovider  "+val);
		return val;
	}
}
