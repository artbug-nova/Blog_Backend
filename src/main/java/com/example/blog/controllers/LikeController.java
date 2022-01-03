package com.example.blog.controllers;

import com.example.blog.models.Like;
import com.example.blog.service.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping(value = "api/like", produces = "application/json")
@RestController
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeRepository) {
        this.likeService = likeRepository;
    }

    @GetMapping("/getAll")
    public List<Like> getAll(){
        return likeService.getAll();
    }

    @GetMapping("/{id}")
    public Like getById(@PathVariable(value = "id") Long id) {
        return likeService.getById(id);
    }

    @PostMapping("/addLike")
    public Like addLike(@RequestBody Like like){
        return likeService.save(like);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Like> updateLike(@RequestBody Like like) {
        Like likeModel = likeService.update(like);
        return ResponseEntity.ok(likeModel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLike(@PathVariable(value = "id") Long id) {
        likeService.delete(id);
        return "Ok";
    }
}
