package com.example.blog.service;

import com.example.blog.models.User;

public interface UserService {
    User save(User userEntity);
    User findByUserName(String login);
    User findByUserNameAndPassword(String login, String password);
}
