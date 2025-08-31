package com.adhiraj.enterpries.exception;

import java.util.zip.DataFormatException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Null pointer exception: " + ex.getMessage());
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + ex.getMessage());
	}

	@ExceptionHandler(DataFormatException.class)
	public ResponseEntity<String> handleDataFormatException(DataFormatException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data format error: " + ex.getMessage());
	}
}