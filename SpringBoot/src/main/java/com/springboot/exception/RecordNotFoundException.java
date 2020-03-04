package com.springboot.exception;

public class RecordNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(final String message) {
		super(message);
	}

}
