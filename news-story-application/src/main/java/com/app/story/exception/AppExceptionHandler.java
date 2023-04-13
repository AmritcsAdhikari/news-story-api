package com.app.story.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @Value(value = "${data.exception.code.story-not-found}")
    private String msg1;
    @Value(value = "${data.exception.code.story-not-saved}")
    private String msg2;
    @Value(value = "${data.exception.code.invalid-method-args}")
    private String msg3;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        AppError appError = AppError.builder()
                .errorCode(msg3)
                .message(errorMap)
                .timeStamp(Instant.now())
                .build();
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StoryNotFoundException.class)
    public ResponseEntity<AppError> handleStoryNotFoundException(StoryNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("msg",exception.getLocalizedMessage());

        AppError appError = AppError.builder()
                .errorCode(msg1)
                .message(errorMap)
                .timeStamp(Instant.now())
                .build();
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FailedSaveException.class)
    public ResponseEntity<AppError> handleFailedSaveException(FailedSaveException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("msg",exception.getLocalizedMessage());

        AppError appError = AppError.builder()
                .errorCode(msg2)
                .message(errorMap)
                .timeStamp(Instant.now())
                .build();
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }
}
