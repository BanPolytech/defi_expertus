package com.expertus_defi.services;

import com.expertus_defi.persistence.StoryRepository;


public class PublicationService {

    private StoryRepository storyRepository;

    public PublicationService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void share(Story content) {
        storyRepository.save(content);
    }
}