package com.chanhk.lifelog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class LifeLogException extends RuntimeException {
    private final HttpStatus httpStatus;

    public LifeLogException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
