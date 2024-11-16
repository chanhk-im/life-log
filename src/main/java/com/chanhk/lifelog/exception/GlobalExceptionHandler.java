package com.chanhk.lifelog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LifeLogException.class)
    public ResponseEntity<String> handleLifeLogException(LifeLogException e) {
        if (e.getHttpStatus().is4xxClientError())
            return ResponseEntity.status(e.getHttpStatus()).body("Client error: " + e.getMessage());
        else if (e.getHttpStatus().is5xxServerError())
            return ResponseEntity.status(e.getHttpStatus()).body("Server error: " + e.getMessage());
        else return ResponseEntity.status(e.getHttpStatus()).body("Unknown error: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
    }
}
