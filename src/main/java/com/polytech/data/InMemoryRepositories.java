package com.polytech.data;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepositories implements StoryRepository {

    List<Story> database;

    public InMemoryRepositories() {
        this.database = new ArrayList<Story>();
    }

    public void save(Story story) {
        database.add(story);
    }

    public List<Story> fetchAll() {
        return database;
    }
}
