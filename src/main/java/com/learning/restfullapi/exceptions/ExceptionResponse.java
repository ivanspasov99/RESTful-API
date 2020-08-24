package com.learning.restfullapi.exceptions;

public class ExceptionResponse {

    private final String message;

    public ExceptionResponse(Exception ex) {
        this.message = ex.getMessage();
    }

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
