package com.example.blog.mapper;

import com.example.blog.dto.PostDTO;
import com.example.blog.dto.PostSup;


public interface PostMapper {
    PostDTO fromPost(PostSup post);
}
