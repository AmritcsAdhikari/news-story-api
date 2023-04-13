package com.app.story.exception;

import lombok.*;

import java.time.Instant;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppError {
    private String errorCode;
    private Map<String,String> message;
    private Instant timeStamp;
}
