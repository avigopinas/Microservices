package com.app.microservices.user.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	public final ResponseEntity<ErrorDTO> handleUserNotFoundExpetion(Exception ex, WebRequest request)
			throws Exception {
		ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> msg = new ArrayList<>();
		for (FieldError error : ex.getFieldErrors()) {
			msg.add(error.getDefaultMessage());
		}
		ErrorDTO errorDTO = new ErrorDTO(LocalDate.now(), "Validation failed count  "+ ex.getErrorCount(), msg.toString());


		return new ResponseEntity<Object>(errorDTO, HttpStatus.BAD_REQUEST);
	}
}
