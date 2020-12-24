package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repository.PostRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/post", produces = "application/json")
@Api(value = "Вернуть все посты", description = "Вовзрвщает все")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/getById/{id}")
    public Post getById(@PathVariable(value = "id") Long postId) throws Exception {

        return postRepository.findById(postId).orElseThrow(()-> new Exception("not found"));
    }

    @GetMapping("/getAll")
    public List<Post> getAllPost(){
        log.info("getAllPost");
        return postRepository.findAll();
    }

    @PostMapping("/addPost1")
    public Post addPost(@RequestBody Post post){
        postRepository.save(post);
        return post;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> Put(@PathVariable(value = "id") Long id, @RequestBody Post post) throws Exception {
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new Exception("Post " + id + " not found"));
        findPost.setPostName(post.getPostName());
        findPost.setPostStatus(post.getPostStatus());
        final Post updatePost = postRepository.save(findPost);
        return ResponseEntity.ok(findPost);
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws Exception{
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new Exception("Post " + id + " not found"));
        postRepository.delete(post);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}
