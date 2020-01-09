package com.dendoc.registration.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String loginName) {
		super("User not found : " + loginName);
	}

}
