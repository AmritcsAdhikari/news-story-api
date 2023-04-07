package com.app.story.service;

import com.app.story.domain.Story;
import com.app.story.repository.StoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;

    @Transactional(readOnly = true)
    public List<Story> getStories(){
        return storyRepository.findAll();
    }
}
