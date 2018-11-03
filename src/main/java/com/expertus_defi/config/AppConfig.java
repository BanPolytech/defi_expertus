package com.expertus_defi.config;

import com.expertus_defi.persistence.JdbcStoryRepository;
import com.expertus_defi.persistence.StoryRepository;
import com.expertus_defi.services.FeedService;
import com.expertus_defi.services.PublicationService;
import com.expertus_defi.web.FeedController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppConfig {


    @Bean
    public StoryRepository storyRepository(DataSource dataSource) throws SQLException {
        return new JdbcStoryRepository(dataSource.getConnection());
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

    @Bean
    public JdbcStoryRepository jdbcStoryRepository(DataSource dataSource) throws SQLException {
        return new JdbcStoryRepository(dataSource.getConnection());
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                //.addScripts("schema.sql")
                .build();
    }
}