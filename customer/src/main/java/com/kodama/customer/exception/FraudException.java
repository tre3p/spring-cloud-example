package com.kodama.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class FraudException extends RuntimeException {
    public FraudException(String message) {
        super(message);
    }
}
