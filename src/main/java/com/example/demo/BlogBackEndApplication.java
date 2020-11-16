package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogBackEndApplication {
    static Log log = LogFactory.getLog(BlogBackEndApplication.class.getName());
    public static void main(String[] args) {

        SpringApplication.run(BlogBackEndApplication.class, args);
    }
}
