package com.expertus_defi.web;

import com.expertus_defi.services.FeedService;
import com.expertus_defi.services.PublicationService;
import com.expertus_defi.services.Story;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedRestController {

    private FeedService feedService;
    private PublicationService publicationService;

    public FeedRestController(FeedService feedService, PublicationService publicationService) {
        this.feedService = feedService;
        this.publicationService = publicationService;
    }

    @RequestMapping(value = "/api/feed", method = RequestMethod.GET)
    public List<Story> stories() {
        List<Story> stories = feedService.fetchAll();
        return stories;
    }

    @RequestMapping(value = "/api/feed", method = RequestMethod.POST)
    public Story post(@RequestBody Story story) {
        publicationService.share(story);
        return story;
    }
}
