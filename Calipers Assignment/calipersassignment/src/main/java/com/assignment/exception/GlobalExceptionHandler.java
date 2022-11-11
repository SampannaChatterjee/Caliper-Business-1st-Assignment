package com.assignment.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BuyerException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(BuyerException be,WebRequest wr){
		ErrorDetails err=new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDetails(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(ProductException pe,WebRequest wr){
		ErrorDetails err=new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		err.setDetails(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(SellerException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(SellerException se,WebRequest wr){
		ErrorDetails err=new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(ServiceException se,WebRequest wr){
		ErrorDetails err=new ErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);	
	}
	

}
