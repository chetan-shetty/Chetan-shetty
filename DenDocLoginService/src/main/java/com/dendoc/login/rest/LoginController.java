package com.dendoc.login.rest;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dendoc.login.model.Login;
import com.dendoc.login.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@FeignClient(name="ZUUL-SERVER")
@Api(tags = "User DenDocLogin Service")
public class LoginController {
	
	Logger logger = Logger.getLogger(LoginController.class.getName());

	@Autowired
	LoginService loginService;
	
	@Value("${server.port}")
	private int port;
	
	@PostMapping("/login-service/validate")
	@ApiOperation(value = "this is validateUser user service")
	public ResponseEntity<Login> validateUser(@RequestBody Login login){
		
		logger.info(">>>>>>>>>>>>>login>>>>>>>>>>>>>"+login.getLoginName());
		
		Login  regUser= loginService.validateUser(login);
		
		logger.info(">>>>>>>>>>>>>validated user>>>>>>>>>>>>>"+login.getLoginName());
		
		return new ResponseEntity<>(regUser,HttpStatus.OK);				
	}
	
}
