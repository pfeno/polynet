package com.polytech.rest;

import com.polytech.business.PublicationService;
import com.polytech.data.InMemoryRepositories;
import com.polytech.data.Story;
import com.polytech.data.StoryRepository;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "*")
public class StoryController {

    private PublicationService publicationService;
    private int skip;
    private int limit;

    public StoryController() {
        // instantiate and inject dependencies ...
        StoryRepository storyRepository = new InMemoryRepositories();
        publicationService = new PublicationService(storyRepository);
    }

    /*
        @PostMapping("/stories")
        @ResponseStatus(HttpStatus.CREATED)
        protected void share(@RequestParam() String content) {
            publicationService.share(new Story(content));
        }
    */
    @PostMapping("/stories")
    @ResponseStatus(HttpStatus.CREATED)
    protected void share(@RequestBody String content) {
        publicationService.share(new Story(content));
    }



        @GetMapping("/stories")
        @ResponseStatus(HttpStatus.ACCEPTED)
        protected List<Story> fetchAll(@RequestParam(value="skip", defaultValue = "0") int skip, @RequestParam(value="limit", defaultValue = "0") int limit) {
            if (skip == 0 && limit == 0) {
                return publicationService.fetchAll();
            }
            else return publicationService.fetchLimit(skip, limit);
        }
        /*
        @RequestMapping(value = "/stories/{skip}/{limit}",
            method = RequestMethod.GET,
            consumes = "application/json",
            produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    protected List<Story> fetchAll(@PathVariable int skip, @PathVariable int limit) {
        if (skip == 0 && limit == 0) {
            return publicationService.fetchAll();
        } else return publicationService.fetchLimit(skip, limit);
    }
*/
}
