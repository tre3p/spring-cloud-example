package com.kodama.customer.exception.handler;

import com.kodama.customer.exception.FraudException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(FraudException.class)
    @ResponseStatus(UNAUTHORIZED)
    public String fraudExceptionHandler(FraudException exc) {
        return exc.getMessage();
    }
}
