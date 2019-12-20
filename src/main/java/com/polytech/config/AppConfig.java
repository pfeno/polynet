package com.polytech.config;

import com.polytech.business.PublicationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//import com.polytech.business.PublicationService;
import com.polytech.data.StoryRepository;
//import com.polytech.business.PublicationService;
//import com.polytech.data.StoryRepository;
import com.polytech.data.JdbcRepositories;

@Configuration
public class AppConfig {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    DataSource datasource () {
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(url);
        configuration.setUsername(username);
        configuration.setPassword(password);
        DataSource datasource = new HikariDataSource(configuration);
        return datasource;
    }
/*
    @Bean  // Inj. Dép.
    //StoryRepository storyRepository () { return new JdbcRepositories(datasource());  }
    StoryRepository storyRepository () { return new  JdbcRepositories(datasource());  }

    @Bean  // Inj. Dép.
    PublicationService publicationService () {
        return new PublicationService(storyRepository());
    }

 */
}
