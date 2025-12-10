package com.pluralsight.Sakila_Actor_app.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class DbConfig {

    private BasicDataSource basicDataSource;

    @Bean
    public DataSource basicDataSource(){
        return basicDataSource;
    }

    public DbConfig(@Value("${datasource.url}") String url,
                    @Value("${datasource.username}") String username,
                    @Value("${datasource.password}") String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }
}
