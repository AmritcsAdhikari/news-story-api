package com.app.story.service;

import com.app.story.domain.Story;
import com.app.story.dto.StoriesDTO;
import com.app.story.dto.StoryDTO;
import com.app.story.dto.StoryRequest;
import com.app.story.domain.Division;
import com.app.story.exception.FailedSaveException;
import com.app.story.exception.StoryNotFoundException;
import com.app.story.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;


@Service
@Transactional
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Transactional(readOnly = true)
    public StoriesDTO getAllStories(Integer page){
        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = PageRequest.of(pageNo, 4, Sort.Direction.DESC, "createdAt");
        Page<Story> storyPage = storyRepository.findAll(pageable);
        return StoriesDTO.builder()
                .data(storyPage.getContent())
                .totalElements(storyPage.getTotalElements())
                .totalPages(storyPage.getTotalPages())
                .currentPage(storyPage.getNumber() + 1)
                .isFirst(storyPage.isFirst())
                .isLast(storyPage.isLast())
                .hasNext(storyPage.hasNext())
                .hasPrevious(storyPage.hasPrevious())
                .build();
    }

    @Transactional(readOnly = true)
    public StoryDTO getStoryById(Long id){
        Optional<Story> story = storyRepository.findById(id);
        return story.map(value -> StoryDTO.builder()
                .id(value.getId())
                .title(value.getTitle())
                .link(value.getLink())
                .division(value.getDivision().toString())
                .createdAt(value.getCreatedAt())
                .build()).orElseThrow(()-> new StoryNotFoundException("No Story found for id -" + id));
    }

    public StoryDTO createStory(StoryRequest storyRequest) {

        Story build = Story.builder()
                .title(storyRequest.getTitle())
                .link(storyRequest.getLink())
                .division(Division.valueOf(storyRequest.getDivision()))
                .createdAt(Instant.now()).build();

        Story story = storyRepository.save(build);
        if(story.getId() != null){
            return mapToDto(story);
        }
        else {
            throw new FailedSaveException("Story Failed to save");
        }
    }
    
    public StoryDTO updateStory(StoryDTO storyDTO) {
        if (storyRepository.existsById(storyDTO.getId())) {
            Story save = storyRepository.save(mapToEntity(storyDTO));
            return mapToDto(save);
        } else {
            throw new StoryNotFoundException("Cannot find story with given id - " + storyDTO.getId());
        }
    }

    public void deleteStoryById(Long id){
        if(storyRepository.existsById(id)){
            storyRepository.deleteById(id);
        }
        else{
            throw new StoryNotFoundException("Story with id - " + id + " does not exist.");
        }
    }

    private Story mapToEntity(StoryDTO storyDTO){
        return Story.builder()
                .id(storyDTO.getId())
                .title(storyDTO.getTitle())
                .link(storyDTO.getLink())
                .division(Division.valueOf(storyDTO.getDivision()))
                .createdAt(storyDTO.getCreatedAt())
                .build();
    }

    private StoryDTO mapToDto(Story story){
        return StoryDTO.builder()
                .id(story.getId())
                .title(story.getTitle())
                .link(story.getLink())
                .division(story.getDivision().toString())
                .createdAt(story.getCreatedAt())
                .build();
    }

}
