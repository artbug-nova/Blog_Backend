package com.example.blog.controllers;

import com.example.blog.models.User;
import com.example.blog.modelui.UserUi;
import com.example.blog.service.SecurityService;
import com.example.blog.service.UserService;
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

    @GetMapping("/getuser")
    public UserUi get(String name){
        User user = userService.findByuserName(name);
        UserUi userUi = new UserUi();
        userUi.setUserName(user.getUserName());
        userUi.setPassword(user.getPassword());
        return userUi;
    }
}