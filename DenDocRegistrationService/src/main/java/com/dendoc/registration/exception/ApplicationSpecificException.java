package com.dendoc.registration.exception;

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

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<GenericErrorMessage> userNotFound(Exception ex,
			WebRequest request) throws IOException {

		GenericErrorMessage geMessage = new GenericErrorMessage();
		geMessage.setErrorMessage(ex.getMessage());
		geMessage.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(geMessage, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(UserExisitException.class)
	public ResponseEntity<GenericErrorMessage> userFound(Exception ex,
			WebRequest request) throws IOException {

		GenericErrorMessage geMessage = new GenericErrorMessage();
		geMessage.setErrorMessage(ex.getMessage());
		geMessage.setStatusCode(HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(geMessage, HttpStatus.CONFLICT);
	}
}