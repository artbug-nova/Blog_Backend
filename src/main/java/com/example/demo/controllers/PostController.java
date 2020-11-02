package com.example.demo.controllers;

import com.example.demo.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/{id}")
    public Post Get(@PathVariable(value = "id") Long postId) throws Exception {
        return postRepository.findById(postId).orElseThrow(()-> new Exception("not found"));
    }

    @GetMapping("/all")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }


    @GetMapping("/gets")
    public List<Post> GetPost(String PostName, String PostStatus){
        List<Post> byPostNameAndId = postRepository.findByPostNameOrPostStatus(PostName, PostStatus);
        return byPostNameAndId;
    }

    @PostMapping("/add")
    public Post Post(@RequestBody Post post){
        return postRepository.save(post);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Post> Put(@PathVariable(value = "id") Long id, @RequestBody Post post) throws Exception {
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new Exception("Phone " + id + " not found"));
        findPost.setPostName(post.getPostName());
        findPost.setPostStatus(post.getPostStatus());
        final Post updatePost = postRepository.save(findPost);
        return ResponseEntity.ok(findPost);
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id) throws Exception{
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new Exception("Phone " + id + " not found"));
        postRepository.delete(post);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}
