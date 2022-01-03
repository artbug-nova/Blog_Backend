package com.example.blog.service;

import com.example.blog.models.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post getById(Long id);
    Post save(Post post);
    Post update(Post post);
    void delete(Long id);
}