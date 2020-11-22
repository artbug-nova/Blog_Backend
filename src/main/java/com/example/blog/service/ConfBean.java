package com.example.blog.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfBean {
    @Bean
    public SimpleImpl statusImpl(){
        return new SimpleImpl();
    }

}
