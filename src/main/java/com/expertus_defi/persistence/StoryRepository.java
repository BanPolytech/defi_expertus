package com.expertus_defi.persistence;

import com.expertus_defi.services.Story;

import java.util.ArrayList;
import java.util.List;

public class StoryRepository {

    private static List<Story> database = new ArrayList<>();

    public void save(Story content) {
        database.add(content);
    }

    public List<Story> findAll() {
        return database;
    }
}