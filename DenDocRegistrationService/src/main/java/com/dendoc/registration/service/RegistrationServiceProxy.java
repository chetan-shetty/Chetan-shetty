/**
 * 
 */
package com.dendoc.registration.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dendoc.registration.model.UserProvider;

/**
 * @author Chetan
 *
 */
@FeignClient(name="ZUUL-SERVER")
public interface RegistrationServiceProxy {
	
	@PostMapping("/provider-service/provider-service/insertLoginProvider")
	public boolean insertLoginProvider(@RequestBody UserProvider users);
}
