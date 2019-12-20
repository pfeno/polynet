package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepositories;
import com.polytech.data.JdbcRepositories;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController()
@CrossOrigin(origins = "*",allowCredentials = "true")
public class StoryController {

    private PublicationService publicationService;

    public StoryController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }
    @PostMapping("/stories")
    @ResponseStatus(HttpStatus.CREATED)
    protected void share(@RequestParam() String content) throws SQLException {
        publicationService.share(new Story(content));
    }
    /*
    @PostMapping("/stories")
    @ResponseStatus(HttpStatus.CREATED)
    protected void share(@RequestBody String content) {
        publicationService.share(new Story(content));
    }
*/

    @GetMapping("/stories")
    @ResponseStatus(HttpStatus.ACCEPTED)
    protected List<Story> fetchAll(@RequestParam(value = "skip", defaultValue = "0") int skip, @RequestParam(value = "limit", defaultValue = "0") int limit) {
        if (skip == 0 && limit == 0) {
            return publicationService.fetchAll();
        } else return publicationService.fetchAll(); //fetchLimit(skip, limit);
    }

/*
    @RequestMapping(value = "/stories/{skip}/{limit}", // notion de resources dispo / pas une bonne idée ici
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    protected List<Story> fetchAll(@PathVariable(required = false) int skip, @PathVariable int limit) {
        if (skip == 0 && limit == 0) {
            return publicationService.fetchAll();
        } else return publicationService.fetchLimit(skip, limit);
    }
  */
}
