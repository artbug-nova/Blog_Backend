package com.example.blog.models;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;

    @ApiModelProperty(value = "Имя поста", example = "Имя")
    @Column(name = "post_name", nullable = false)
    private String postName;

    @ApiModelProperty(value = "Статус поста", example = "Create")
    @Column(name = "post_status", nullable = false)
    private String postStatus;

}
