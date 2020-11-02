package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HomeController {
    private final ArrayList<String> _aa;

    public HomeController() {
        _aa = new ArrayList<String>();
        _aa.add("Alex");
        _aa.add("Kate");
        _aa.add("Set");
    }

    @GetMapping("/home/index")
    public String GetAll(String name){
        return "Hello World";
    }
}
