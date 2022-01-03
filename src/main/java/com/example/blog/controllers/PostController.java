package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.service.PostService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/post", produces = "application/json")
@Api(value = "Вернуть все посты", description = "Вовзрвщает все")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable(value = "id") Long id) {
        return postService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Post> getAllPost(){
        log.info("getAllPost");
        return postService.getAll();
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        return postService.save(post);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> Put(@RequestBody Post post) {
        postService.update(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        postService.delete(id);
        return "Ok";
    }
}
