package com.example.blog.mapper;

import com.example.blog.dto.PostDTO;
import com.example.blog.dto.PostSup;
import com.example.blog.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    @Mappings({
        @Mapping(target = "postName", expression = "java(post.getPostName() + \" \" + post.getPostStatus())")
    })
    PostDTO fromPost(Post post);
}
