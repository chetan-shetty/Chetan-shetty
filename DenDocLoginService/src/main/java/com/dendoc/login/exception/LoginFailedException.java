package com.dendoc.login.exception;

public class LoginFailedException extends RuntimeException {

	public LoginFailedException(String loginName) {
		super("User already registered : " + loginName);
	}
}