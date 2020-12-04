package com.example.blog.controllers;

import com.example.blog.models.Like;
import com.example.blog.repository.LikeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping(value = "api/like", produces = "application/json")
@RestController
public class LikeController {
    private final LikeRepository likeRepository;

    public LikeController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @GetMapping("/all")
    public List<Like> getAll(){
        return likeRepository.findAll();
    }

    @PostMapping("/addLike")
    public Like addLike(@RequestBody Like like){
        likeRepository.save(like);
        return like;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Like> updateLike(@PathVariable(value = "id") Long id, @RequestBody Like like) throws Exception{
        Like likeModel = likeRepository.findById(id).orElseThrow(() -> new Exception("Like not found"));
        likeModel.setName(like.getName());
        likeModel.setPost(like.getPost());
        final Like updateLike = likeRepository.save(likeModel);
        return ResponseEntity.ok(likeModel);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteLike(@PathVariable(value = "id") Long id) throws Exception {
        Like like = likeRepository.findById(id).orElseThrow(() -> new Exception("Like not found"));
        likeRepository.delete(like);
        Map<String, Boolean> deleted = new HashMap();
        deleted.put(like.getName(), true);
        return deleted;
    }
}
