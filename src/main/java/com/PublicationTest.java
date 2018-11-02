package com;

import com.expertus_defi.services.Story;
import com.expertus_defi.web.FeedController;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PublicationTest {

    @Test
    public void should_post_story() {

        //GIVEN
        String story = "hi Expertus !";
        FeedController feedController = new FeedController();

        //WHEN
        feedController.post(story);

        //THEN

        List<Story> postedStories = feedController.feed();
        Assert.assertEquals(Arrays.asList(new Story("hi Expertus !")), postedStories);

    }
}