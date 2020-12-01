package com.example.blog.controllers;


import com.example.blog.service.Simple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
public class HomeController {
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
        log.info("hello app");
        log.debug("hello app");
        log.error("hello app");
        log.trace("hello app");
        return simple.Status();
    }
}
