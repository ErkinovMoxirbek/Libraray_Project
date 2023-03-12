package org.example.config;

import org.example.DB.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Config {
    @Bean
    public Database database (){
        return new Database();
    }

}
