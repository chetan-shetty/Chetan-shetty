package com.dendoc.client.exception;

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

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<GenericErrorMessage> dataNotFound(Exception ex,
			WebRequest request) throws IOException {

		GenericErrorMessage geMessage = new GenericErrorMessage();
		geMessage.setErrorMessage(ex.getMessage());
		geMessage.setStatusCode(HttpStatus.CONFLICT.value());
		return new ResponseEntity<>(geMessage, HttpStatus.CONFLICT);
	}
}