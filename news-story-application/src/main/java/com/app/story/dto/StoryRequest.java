package com.app.story.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryRequest {
    @NotNull (message = "Title cannot be null")
    @NotEmpty (message = "Title cannot be empty")
    private String title;
    @NotBlank (message = "Link cannot be Blank")
    private String link;
    @Pattern(regexp = "BUSINESS|ENTERTAINMENT|POLITICS")
    private String division;
}
