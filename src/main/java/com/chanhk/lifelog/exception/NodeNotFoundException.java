package com.chanhk.lifelog.exception;

import org.springframework.http.HttpStatus;

public class NodeNotFoundException extends NodeException {
    public NodeNotFoundException() {
        super(ExceptionMessage.NODE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
