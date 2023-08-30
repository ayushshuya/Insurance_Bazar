package com.app.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String mesg, Long userId) {
		super(mesg);
	}

	public ResourceNotFoundException(String email, String password, int i) {
		// TODO Auto-generated constructor stub
	}

}
