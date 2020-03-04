package com.springboot.exception;

public class EmployeeServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public EmployeeServiceException() {
		super();
	}
	public EmployeeServiceException(final String message) {
		super(message);
	}

}
