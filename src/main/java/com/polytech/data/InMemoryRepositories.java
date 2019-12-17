package com.polytech.data;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepositories implements StoryRepository {

    private List<Story> database;

    public InMemoryRepositories() {
        this.database = new ArrayList<Story>();
    }

    public void save(Story story) {
        database.add(story);
    }

    public List<Story> fetchAll() {
        return database;
    }

    public List<Story> fetchLimit(int skip, int limit) {
        if (skip + limit > database.size()) {
            return database.subList(skip, database.size());
        }
        else return database.subList(skip, skip + limit);
    }
}
