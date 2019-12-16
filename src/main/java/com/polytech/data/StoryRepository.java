package com.polytech.data;

import java.util.List;

public interface StoryRepository {
    public void save(Story story);
    public List<Story> fetchAll();
}
