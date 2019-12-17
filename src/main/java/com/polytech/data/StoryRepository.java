package com.polytech.data;

import java.util.List;

public interface StoryRepository {
    void save(Story story);
    List<Story> fetchAll();
    List<Story> fetchLimit(int skip, int limit);
}
