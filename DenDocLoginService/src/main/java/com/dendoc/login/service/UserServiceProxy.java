package com.dendoc.login.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dendoc.login.model.Users;


@FeignClient(name="ZUUL-SERVER")
public interface UserServiceProxy {
	
	@GetMapping("/registration-service/registration-service/verify/user/{loginName}")
	public boolean verifyLoginName(@PathVariable(value="loginName") String loginName);
	
	@PostMapping("/registration-service/registration-service/register")
	public Users registerUser(@RequestBody Users users);
	
	@GetMapping("/registration-service/registration-service/user/{loginName}")
	public Users getUserByLoginName(@PathVariable(value="loginName") String loginName);

}
