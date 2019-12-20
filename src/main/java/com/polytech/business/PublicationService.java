package com.polytech.business;

import com.polytech.data.Story;
import com.polytech.data.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PublicationService {
    @Autowired
    private StoryRepository storyRepository;


    public  PublicationService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void share(Story story) throws SQLException {
        storyRepository.save(story);
    }

    public List<Story> fetchAll() {
        return storyRepository.findAll();
    }

    public List<Story> fetchLimit(int skip, int limit) {
        return storyRepository.findAll();
    }
}
