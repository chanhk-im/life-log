package com.chanhk.lifelog.exception;

import org.springframework.http.HttpStatus;

public class ParentNodeNotFoundException extends NodeException {
    public ParentNodeNotFoundException() {
        super(ExceptionMessage.PARENT_NODE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
