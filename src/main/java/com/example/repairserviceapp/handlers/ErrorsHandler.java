package com.example.repairserviceapp.handlers;

import com.example.repairserviceapp.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ErrorsHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ApplicationException ex) {
        log.warn("{} {}",ex.getClass().getSimpleName(), ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(new ErrorResponse(ex.getMessage(), LocalDateTime.now()));
//        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), LocalDateTime.now()), ex.getStatus());
    }
}
