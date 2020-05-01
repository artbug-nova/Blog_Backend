package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/registration")
    public User registration(@RequestBody User userRequset) throws Exception {
        userService.save(userRequset);
        securityService.autoLogin(userRequset.getUserName(), userRequset.getPasswordConfirm());

        return userRequset;
    }


    @PostMapping("/login")
    public User login(@RequestBody User userRequest){
        return userRequest;
    }
}