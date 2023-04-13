package com.app.story.exception;

import lombok.Data;

public class StoryNotFoundException extends RuntimeException {
    public StoryNotFoundException(String message) {
        super(message);
    }
}
