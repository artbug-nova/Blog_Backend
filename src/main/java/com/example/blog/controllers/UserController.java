package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.service.UserService;
import com.example.blog.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final JwtUtil jwtUtil;

    private final UserService userService;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/getByUserName")
    public User getByUserName(String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/getByLoginAndPassword")
    public User getByLoginAndPassword(String userName, String password){
        return userService.findByUserNameAndPassword(userName, password);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody @Valid User registrationUser) {
        return userService.save(registrationUser);
    }

    @GetMapping("/auth")
    public String auth(String userName, String password) {
        User userEntity = userService.findByUserNameAndPassword(userName, password);
        return jwtUtil.generateToken(userEntity.getUserName());
    }
}