package com.dendoc.login.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dendoc.login.model.Login;
import com.dendoc.login.model.UserProvider;
import com.dendoc.login.model.Users;
import com.dendoc.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@FeignClient(name = "ZUUL-SERVER")
@Api(tags = "User DenDocLogin Service")
public class LoginController {

	Logger logger = Logger.getLogger(LoginController.class.getName());

	@Autowired
	LoginService loginService;

	@Value("${server.port}")
	private int port;

	@PostMapping("/login-service/validate")
	@ApiOperation(value = "this is validateUser user service")
	public ResponseEntity<Login> validateUser(@RequestBody Login login) {

		logger.info(">>>>>>>>>>>>>login>>>>>>>>>>>>>" + login.getLoginName());

		Login regUser = loginService.validateUser(login);

		logger.info(">>>>>>>>>>>>>validated user>>>>>>>>>>>>>" + login.getLoginName());

		return new ResponseEntity<>(regUser, HttpStatus.OK);
	}

	@PostMapping("/login-service/loginRegister")
	@ApiOperation(value = "this is register user service")
	public ResponseEntity<Users> loginRegister(@RequestBody UserProvider userProvider) {

		Users users = userProvider.getUsers();
		logger.info(">>>>>>>>>>>>>user>>>>>>>>>>>>>" + users);

		Users regUser = loginService.registerUser(users);
		logger.info(">>>>>>>>>>>>>regUserregUser>>>>>>>>>>>>>" + regUser.toString());
		userProvider.getProvider().setProviderId(regUser.getUserId());

		logger.info(">>>>>>>>>>>>>userProvider  val >>>>>>>>>>>>>" + userProvider);
		
		  boolean userProviders = loginService.insertUserPRovider(userProvider);
		  logger.info(">>>>>>>>>>>>>userProviders>>>>>>>>>>>>>" + userProviders);
		 

		return new ResponseEntity<>(regUser, HttpStatus.OK);
	}
}
