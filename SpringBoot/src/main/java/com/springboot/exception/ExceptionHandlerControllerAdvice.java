package com.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleRecordNotFoundException(final RecordNotFoundException exception, final HttpServletRequest request) {
		ExceptionResponse error=new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestURI(request.getRequestURI());
		
		return error;
		
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception, final HttpServletRequest request) {
		ExceptionResponse error=new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestURI(request.getRequestURI());
		return error;
	}
}
