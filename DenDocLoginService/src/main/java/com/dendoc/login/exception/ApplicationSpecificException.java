package com.dendoc.login.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationSpecificException extends
		ResponseEntityExceptionHandler {

	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<GenericErrorMessage> validateUser(Exception ex,
			WebRequest request) throws IOException {

		GenericErrorMessage geMessage = new GenericErrorMessage();
		geMessage.setErrorMessage(ex.getMessage());
		geMessage.setStatusCode(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value());
		return new ResponseEntity<>(geMessage, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}

	
	
}