package com.pluralsight.Sakila_Actor_app.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private BasicDataSource dataSource;

    @Bean
    public DataSource getDataSource(){
        return dataSource;
    }

    public DbConfig(@Value("${datasource.url}") String url,
                    @Value("${datasource.username}") String username,
                    @Value("${datasource.password}") String password){
        this.dataSource = new BasicDataSource();
        this.dataSource.setUrl(url);
        this.dataSource.setUsername(username);
        this.dataSource.setPassword(password);
    }
}
