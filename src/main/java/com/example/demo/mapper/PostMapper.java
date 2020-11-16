package com.example.demo.mapper;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostSup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    @Mappings({
            @Mapping(target="id", source="post.employeeId"),
            @Mapping(target="postName", source="post.postName")
    })
    PostDTO fromPost(PostSup post);
}
