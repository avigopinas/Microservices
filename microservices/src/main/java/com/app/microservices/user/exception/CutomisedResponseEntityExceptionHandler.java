package com.app.microservices.user.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CutomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDTO> handleALLException(Exception ex, WebRequest request) throws Exception {
		ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDTO> handleUserNotFoundExpetion(Exception ex, WebRequest request) throws Exception {
		ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
	}
}
