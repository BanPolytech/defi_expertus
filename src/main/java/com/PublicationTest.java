package com;

import com.expertus_defi.persistence.StoryRepository;
import com.expertus_defi.services.FeedService;
import com.expertus_defi.services.PublicationService;
import com.expertus_defi.services.Story;
import com.expertus_defi.web.FeedController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {

    private FeedController feedController;

    @Before
    public void setUp(){
        StoryRepository storyRepository = new StoryRepository();
        PublicationService publicationService = new PublicationService(storyRepository);
        FeedService feedService = new FeedService(storyRepository);
        feedController = new FeedController(publicationService, feedService);

    }

    @Test
    public void should_post_story() {

        //GIVEN
        String story = "hi Expertus !";

        //WHEN
        feedController.post(story);

        //THEN

        List<Story> postedStories = feedController.feed();
        Assert.assertEquals(Arrays.asList(new Story("hi Expertus !")), postedStories);

    }
}