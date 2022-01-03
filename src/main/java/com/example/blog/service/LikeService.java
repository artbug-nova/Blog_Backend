package com.example.blog.service;

import com.example.blog.models.Like;

import java.util.List;

public interface LikeService {
    List<Like> getAll();
    Like getById(Long id);
    Like save(Like like);
    Like update(Like like);
    void delete(Long id);
}
