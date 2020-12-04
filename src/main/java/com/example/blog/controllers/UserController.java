package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.modelui.UserUi;
import com.example.blog.service.SecurityService;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    private final SecurityService securityService;

    private final UserDetailsService userDetailsService;

    public UserController(SecurityService securityService, UserService userService, @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.securityService = securityService;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/registration")
    public User registration(@RequestBody User userRequset) throws Exception {
        userService.save(userRequset);
        return userRequset;
    }


    @PostMapping("/login")
    public User login(@RequestBody User userRequest){
        UserDetails userDetails = userDetailsService.loadUserByUsername(userRequest.getUserName());
        return userRequest;
    }

    @GetMapping("/getuser")
    public UserUi get(String name){
        User user = userService.findByuserName(name);
        UserUi userUi = new UserUi();
        userUi.setUserName(user.getUserName());
        userUi.setPassword(user.getPassword());
        return userUi;
    }
}