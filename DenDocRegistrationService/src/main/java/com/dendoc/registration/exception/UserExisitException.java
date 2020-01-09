package com.dendoc.registration.exception;

public class UserExisitException extends RuntimeException {

	public UserExisitException(String loginName) {
		super("User already registered : " + loginName);
	}
}