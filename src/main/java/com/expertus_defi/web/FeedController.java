package com.expertus_defi.web;

import com.expertus_defi.services.FeedService;
import com.expertus_defi.services.PublicationService;
import com.expertus_defi.services.Story;

import java.util.List;

public class FeedController {

    private PublicationService publicationService = new PublicationService();
    private FeedService feedService = new FeedService();

    public void post(String content) {
        publicationService.share(new Story(content));
    }

    public List<Story> feed() {
        return feedService.fetchAll();
    }
}