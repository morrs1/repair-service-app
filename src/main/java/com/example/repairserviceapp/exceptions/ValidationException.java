package com.example.repairserviceapp.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationException extends ApplicationException {
    protected Map<String, String> details;

    public ValidationException(String message, Map<String, String> details) {
        super(message);
        this.details = details;
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
