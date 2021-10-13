package com.brs.exceptions;

@SuppressWarnings("serial")
public class RouteNotFoundException extends Exception {
	public RouteNotFoundException(String message) {
		super(message);
	}
}