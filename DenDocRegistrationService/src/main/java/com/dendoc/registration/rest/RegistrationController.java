package com.dendoc.registration.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dendoc.registration.model.UserProvider;
import com.dendoc.registration.model.Users;
import com.dendoc.registration.service.RegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Api(tags = "User Registration Service")
@FeignClient(name = "ZUUL-SERVER")
public class RegistrationController {

	Logger logger = Logger.getLogger(RegistrationController.class.getName());

	@Autowired
	RegistrationService registrationService;

	@Value("${server.port}")
	private int port;

	@PostMapping("/registration-service/register")
	@ApiOperation(value = "this is register user service")
	public ResponseEntity<Users> registerUser(@RequestBody Users users) {

		logger.info(">>>>>>>>>>>>>user>>>>>>>>>>>>>" + users);

		Users regUser = registrationService.registerUser(users);

		logger.info(">>>>>>>>>>>>>regUser>>>>>>>>>>>>>" + regUser);

		return new ResponseEntity<>(regUser, HttpStatus.OK);
	}

	@GetMapping("/registration-service/verify/user/{loginName}")
	@ApiOperation(value = "this is verifyLoginName of user service")
	public ResponseEntity<Boolean> verifyLoginName(@PathVariable(value = "loginName") String loginName) {
		boolean status = registrationService.verifyLoginName(loginName);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/registration-service/user/{loginName}")
	@ApiOperation(value = "this is getUserByLoginName of user service")
	public ResponseEntity<Users> getUserByLoginName(@PathVariable(value = "loginName") String loginName) {
		Users users = registrationService.getUserByLoginName(loginName);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/registration-service/loginRegister")
	 * 
	 * @ApiOperation(value = "this is register user service") public
	 * ResponseEntity<Users> loginRegister(@RequestBody UserProvider userProvider) {
	 * 
	 * Users users = userProvider.getUsers();
	 * logger.info(">>>>>>>>>>>>>user>>>>>>>>>>>>>" + users);
	 * 
	 * Users regUser = registrationService.registerUser(users);
	 * 
	 * boolean userProviders = registrationService.insertUserPRovider(userProvider);
	 * logger.info(">>>>>>>>>>>>>userProviders>>>>>>>>>>>>>" + userProviders);
	 * 
	 * return new ResponseEntity<>(regUser, HttpStatus.OK); }
	 */
}
