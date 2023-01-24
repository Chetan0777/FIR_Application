package com.masai.exceptionhandler;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.masai.exception.FirException;
import com.masai.exception.UserException;

@ControllerAdvice
public class globalException {
	@ExceptionHandler(FirException.class)
	public ResponseEntity<MyDetails> firExecption(FirException e){
		return new ResponseEntity<MyDetails>(new MyDetails(e.getMessage(),LocalDate.now()), HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyDetails> userExecption(UserException e){
		return new ResponseEntity<MyDetails>(new MyDetails(e.getMessage(),LocalDate.now()), HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyDetails> globalExecption(Exception e){
		return new ResponseEntity<MyDetails>(new MyDetails(e.getMessage(),LocalDate.now()), HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyDetails> validationExceptionHandler(MethodArgumentNotValidException e){
		return new ResponseEntity<MyDetails>(new MyDetails(e.getBindingResult().getFieldError().getDefaultMessage(),LocalDate.now()), HttpStatus.BAD_REQUEST);
		
	}
}
