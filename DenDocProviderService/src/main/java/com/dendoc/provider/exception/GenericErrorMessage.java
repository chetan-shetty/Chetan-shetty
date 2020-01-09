package com.dendoc.provider.exception;

public class GenericErrorMessage {

	private int statusCode;
	private String errorMessage;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "GenericErrorMessage [statusCode=" + statusCode
				+ ", errorMessage=" + errorMessage + "]";
	}

}
