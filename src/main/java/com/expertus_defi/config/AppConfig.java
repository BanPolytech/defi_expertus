package com.expertus_defi.config;

import com.expertus_defi.persistence.JdbcStoryRepository;
import com.expertus_defi.persistence.StoryRepository;
import com.expertus_defi.services.FeedService;
import com.expertus_defi.services.PublicationService;
import com.expertus_defi.web.FeedController;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {


    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public StoryRepository storyRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcStoryRepository(jdbcTemplate);
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
    public DataSource dataSource() {
        //  return new EmbeddedDatabaseBuilder()
        //        .build();
        String url = "jdbc:mysql://localhost:3306/defi_expertus";
        String username = "root";
        String password = "root";

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}