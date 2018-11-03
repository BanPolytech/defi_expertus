package com.expertus_defi.services;

import com.expertus_defi.persistence.StoryRepository;

import java.util.List;

public class FeedService {

    private StoryRepository storyRepository;

    public FeedService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> fetchAll() {
        return storyRepository.findAll();
    }
}