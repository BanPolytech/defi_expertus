package com.expertus_defi.config;

import com.expertus_defi.persistence.StoryRepository;
import com.expertus_defi.services.FeedService;
import com.expertus_defi.services.PublicationService;
import com.expertus_defi.web.FeedController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public StoryRepository storyRepository() {
        return new StoryRepository();
    }

    @Bean
    public FeedService
    feedService(StoryRepository storyRepository) {
        return new FeedService(storyRepository);
    }

    @Bean
    public PublicationService publicationService(StoryRepository storyRepository) {
        return new PublicationService(storyRepository);
    }

    @Bean
    public FeedController feedController(PublicationService publicationService, FeedService feedService) {
        return new FeedController(publicationService, feedService);
    }
}