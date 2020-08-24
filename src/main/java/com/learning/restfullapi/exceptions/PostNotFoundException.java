package com.learning.restfullapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends Exception {
    public PostNotFoundException(String mess) {
        super(mess);
    }
}
