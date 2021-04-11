package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException exception)
	{
		return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	

}