package com.Project.Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Project.Dio.ApiErrorService;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// handle runtime exception
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiErrorService> handleRuntimeException(RuntimeException ex) {

		List<String> errors = new ArrayList<>();
		errors.add(ex.getMessage());

		ApiErrorService errorResponse = new ApiErrorService(false, "Runtime error occured", errors);
		return new ResponseEntity<ApiErrorService>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiErrorService> handleValidationException(MethodArgumentNotValidException ex) {

		List<String> validationErrors = ex.getBindingResult().getFieldErrors().stream()
				.map(e -> e.getField() + " : " + e.getDefaultMessage()).collect(Collectors.toList());

		ApiErrorService errorResponse = new ApiErrorService(false, "Validation errors occured", validationErrors);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorService> handleGenericException(Exception ex) {

		List<String> errors = new ArrayList<>();
		errors.add("An unexpected error occured");

		ApiErrorService errorResponse = new ApiErrorService(false, "Internal server error", errors);

		return new ResponseEntity<ApiErrorService>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}