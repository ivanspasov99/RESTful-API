package com.learning.restfullapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.PersistenceException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersistenceException.class)
    protected ResponseEntity<Object> fieldValidationException() {
        return new ResponseEntity<>(new ExceptionResponse("Not Valid Input"), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(PostNotFoundException.class)
    protected ResponseEntity<ExceptionResponse> notFoundException(Exception ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex), HttpStatus.NOT_FOUND);
    }

}
