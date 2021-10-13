package com.brs.exceptions;

public class InvalidCredentials extends Exception{
	private String msg;

	public String getMsg() {
		return msg;
	}

	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "InvalidCredentials [msg=" + msg + "]";
	}

	public InvalidCredentials(String msg) {
		super(msg);

	}

	public InvalidCredentials() {
		super();
	}


}