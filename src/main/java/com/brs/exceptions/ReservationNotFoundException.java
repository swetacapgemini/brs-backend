package com.brs.exceptions;

@SuppressWarnings("serial")
public class ReservationNotFoundException extends Exception {
	public ReservationNotFoundException(String message) {
		super(message);
	}
}
