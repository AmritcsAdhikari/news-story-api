package com.app.story.controller;

import com.app.story.dto.StoriesDTO;
import com.app.story.dto.StoryDTO;
import com.app.story.dto.StoryRequest;
import com.app.story.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/")
public class StoryController {

    @Autowired
    private StoryService service ;
    @GetMapping("/story")
    public ResponseEntity<StoriesDTO> getAllStories(
                            @RequestParam(name="page",defaultValue = "1") Integer page){

        return new ResponseEntity<>(service.getAllStories(page), HttpStatus.OK);
    }
    @PostMapping("/story")
    public ResponseEntity<StoryDTO> createStory(@RequestBody StoryRequest storyRequest){
        return new ResponseEntity<>(service.createStory(storyRequest),HttpStatus.CREATED);
    }
    @GetMapping("story/{id}")
    public ResponseEntity<StoryDTO> getStoryById(@PathVariable Long id){
        return new ResponseEntity<>(service.getStoryById(id),HttpStatus.OK);
    }
    @PutMapping("/story")
    public ResponseEntity<StoryDTO> updateStory(@RequestBody StoryDTO storyDTO){
        return new ResponseEntity<>(service.updateStory(storyDTO),HttpStatus.OK);
    }
    @DeleteMapping("story/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStoryById(@PathVariable Long id){
        service.deleteStoryById(id);
    }



}
