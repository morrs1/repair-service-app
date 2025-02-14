package com.example.repairserviceapp.exceptions;

import org.springframework.http.HttpStatus;

public class MastersValidationException extends ApplicationException {
    public MastersValidationException(String message) {
        super(message);
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
