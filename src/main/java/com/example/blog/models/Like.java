package com.example.blog.models;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "like_post")
public class Like {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Имя", example = "Имя дайка")
    @Column(name = "name_like")
    private String name;

    @Column(name = "author_like")
    private String author;

    @ManyToMany
    @JoinTable(name = "like_post", catalog = "blog", schema = "public", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id", nullable = false))
    private Set<Post> post;

}
