package com.example.demo.controllers;


import com.example.demo.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/index")
    public User GetAll(){
        User us = new User();
        us.setId(1);
        us.setName("Alex");
        return us;
    }
}
