package com.example.demo.controllers;


import com.example.demo.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/index")
    public String GetAll(){
        return null;
    }
}
