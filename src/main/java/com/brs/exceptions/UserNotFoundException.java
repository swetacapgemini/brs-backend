package com.brs.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{
	  
	public UserNotFoundException() {}
	
	public UserNotFoundException(String message) {
		super();
	}
	
}