package com.expertus_defi.services;

import com.expertus_defi.persistence.StoryRepository;


public class PublicationService {

    private StoryRepository storyRepository = new StoryRepository();

    public void share(Story content) {
        storyRepository.save(content);
    }
}