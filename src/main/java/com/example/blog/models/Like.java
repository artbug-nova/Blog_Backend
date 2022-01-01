package com.example.blog.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "like_post")
public class Like {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_like")
    private String name;

    @Column(name = "author_like")
    private String author;
}
