package com.poker.backend.rest.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(Exception ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public final ResponseEntity<ExceptionResponse> manejarNumberFormatExcepciones(MethodArgumentTypeMismatchException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		errors.add(ex.getMessage());
		errors.add(ex.getCause().toString());
		errors.add(request.getDescription(false));
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), errors);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);
	}
	
}
