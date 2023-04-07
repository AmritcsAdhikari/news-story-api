package com.app.story.controller;

import com.app.story.domain.Story;
import com.app.story.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/story")
@RequiredArgsConstructor
public class StoryController {
    private StoryService service;

    @GetMapping("/")
    public ResponseEntity<List<Story>> getAllStory(){
        return new ResponseEntity<>(service.getStories(), HttpStatus.OK);
    }
}
