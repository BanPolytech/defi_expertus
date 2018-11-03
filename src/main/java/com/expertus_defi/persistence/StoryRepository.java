package com.expertus_defi.persistence;

import com.expertus_defi.services.Story;

import java.util.List;

public interface StoryRepository {

    void save(Story content);

    List<Story> findAll();
}