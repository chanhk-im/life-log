package com.chanhk.lifelog.exception;

import org.springframework.http.HttpStatus;

public class RootNodeAlreadyExistException extends NodeException {
    public RootNodeAlreadyExistException() {
        super(ExceptionMessage.ROOT_NODE_ALREADY_EXIST, HttpStatus.CONFLICT);
    }
}
