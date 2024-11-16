package com.chanhk.lifelog.exception;

import org.springframework.http.HttpStatus;

public class RootNodeDeletionException extends NodeException {
    public RootNodeDeletionException() {
        super(ExceptionMessage.ROOT_NODE_DELETION, HttpStatus.BAD_REQUEST);
    }
}
