package com.example.blog.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
