package com.example.blog.controllers;

import com.example.blog.dto.PostDTO;
import com.example.blog.dto.PostSup;
import com.example.blog.mapper.PostMapper;
import com.example.blog.models.Post;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.blog.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/post", produces = "application/json")
@Slf4j
@Api(value = "Вернуть все посты", description = "Вовзрвщает все")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/{id}")
    public Post Get(@PathVariable(value = "id") Long postId) throws Exception {

        return postRepository.findById(postId).orElseThrow(()-> new Exception("not found"));
    }
    @GetMapping("/getsss")
    public String Gets(){
        return "Hello World";
    }

    @GetdemoMapping("/all")
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }


    @GetMapping("/gets")
    @ApiOperation(value = "Вовзращает посты", response = List.class)
    public List<Post> GetPost(String PostName, String PostStatus){
        List<Post> byPostNameAndId = postRepository.findByPostNameOrPostStatus(PostName, PostStatus);
        return byPostNameAndId;
    }
    @ApiOperation(value = "Add post")
    @PostMapping("/add")
    public PostDTO Post(@RequestBody PostSup post){
        PostMapper mapper = Mappers.getMapper(PostMapper.class);
        return mapper.fromPost(post);
        //return postRepository.save(post);
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
