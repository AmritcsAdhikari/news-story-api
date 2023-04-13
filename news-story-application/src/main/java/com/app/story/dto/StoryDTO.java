package com.app.story.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryDTO {
    private Long id;
    private String title;
    private String link;
    private String division;
    private Instant createdAt;
}
