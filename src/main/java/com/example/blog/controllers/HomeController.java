package com.example.blog.controllers;


import com.example.blog.service.Simple;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);
    private final ArrayList<String> _aa;

    @Autowired
    @Qualifier("statusImpl")
    private Simple simple;
    public HomeController() {
        _aa = new ArrayList<String>();
        _aa.add("Alex");
        _aa.add("Kate");
        _aa.add("Set");
    }

    @GetMapping("/home/index")
    public String GetAll(String name){
        return simple.Status();
    }
}
