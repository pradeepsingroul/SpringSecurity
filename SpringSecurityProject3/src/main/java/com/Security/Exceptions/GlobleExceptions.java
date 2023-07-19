package com.Security.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobleExceptions {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> allExceptionHandler(Exception e, WebRequest web){
	
		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDescription(web.getDescription(true));
	
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_GATEWAY);
	}

	
	@ExceptionHandler(EmployeeExceptions.class)
	public ResponseEntity<MyErrorDetails> EmployeeExceptionHandler(EmployeeExceptions e, WebRequest web){
	
		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDescription(web.getDescription(true));
	
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_GATEWAY);
	}

	
	@ExceptionHandler(DepartmentExcepttion.class)
	public ResponseEntity<MyErrorDetails> departmentExceptionHanlder(DepartmentExcepttion e, WebRequest web){
	
		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDescription(web.getDescription(true));
	
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_GATEWAY);
	}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NomethodHandler(NoHandlerFoundException e, WebRequest web){
	
		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDescription(web.getDescription(true));
	
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumentExceptionHanlder(MethodArgumentNotValidException e, WebRequest web){
	
		MyErrorDetails error = new MyErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDescription(web.getDescription(true));
	
		return new ResponseEntity<MyErrorDetails>(error,HttpStatus.BAD_GATEWAY);
	}

}
