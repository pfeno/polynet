package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

public class PostController {
    PublicationService publicationService;

    public PostController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    public void share(String content) {
        publicationService.share(new Story(content));
    }
}
