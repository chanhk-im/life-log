package com.chanhk.lifelog.exception;

import org.springframework.http.HttpStatus;

public class NodeException extends LifeLogException {
    public NodeException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
