package com.himanshu.spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.himanshu.spring.exception.Objects.ErrorDetails;
//study function of these class MethodArgumentNotValidException

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest wr) {

		ErrorDetails err = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserException(Exception ex, WebRequest wr) {
		
		System.out.println("user123");
		ErrorDetails err = new ErrorDetails(ex.getMessage(), LocalDateTime.now(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);

	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest wr) {
		System.out.println(ex.getErrorCount());

		ErrorDetails err = new ErrorDetails(ex.getFieldError().getDefaultMessage(), LocalDateTime.now(), wr.getDescription(false));
		return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
	}
}
