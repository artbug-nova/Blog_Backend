package com.example.blog.service;

import com.example.blog.models.User;

public interface UserService {
    void save(User user);

    User findByuserName(String username);
}
