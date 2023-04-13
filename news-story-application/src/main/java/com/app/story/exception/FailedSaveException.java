package com.app.story.exception;

public class FailedSaveException extends RuntimeException {
    public FailedSaveException(String message) {
        super(message);
    }
}
