package com.example.blog.service.impl;

import com.example.blog.models.Like;
import com.example.blog.repository.LikeRepository;
import com.example.blog.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    public LikeServiceImpl(@Autowired LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public List<Like> getAll() {
        return likeRepository.findAll();
    }

    @Override
    public Like getById(Long id) {
        return likeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Like (id = %d) not found", id)));
    }

    @Override
    @Transactional
    public Like save(Like like) {
        return likeRepository.save(like);
    }

    @Override
    @Transactional
    public Like update(Like like) {
        return likeRepository.save(like);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        likeRepository.deleteById(id);
    }
}
