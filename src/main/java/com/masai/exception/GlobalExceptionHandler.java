package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(StudentException ie, WebRequest wr) {
		System.out.println("inside myHandler method...RNE");

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		System.out.println("inside myHandler method...NHFE");

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandlerMain(Exception ie, WebRequest wr) {
		System.out.println("inside myHandler method...EXP");

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

}

/*
 * @ControllerAdvice: This annotation indicates that the class provides
 * centralized exception handling across multiple controllers.
 
 * @ExceptionHandler(StudentException.class): This method handles exceptions of
 * type StudentException. When such an exception occurs, this method will be
 * invoked.
  
 * @ExceptionHandler(NoHandlerFoundException.class): This method handles
 * exceptions of type NoHandlerFoundException. This exception is typically
 * thrown when no appropriate handler is found for a request.
  
 * @ExceptionHandler(Exception.class): This method handles generic exceptions of
 * type Exception. It acts as a catch-all for exceptions that don't match the
 * previous handlers.
 */