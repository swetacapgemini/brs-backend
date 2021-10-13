package com.brs.exceptions;

public class AdminNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
    private String message;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	   

	public AdminNotFoundException() {

	}

	public AdminNotFoundException(String message) {
		super(message);
		
	}

	public AdminNotFoundException(Throwable cause) {
		super(cause);
		
	}

	public AdminNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public AdminNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}


}