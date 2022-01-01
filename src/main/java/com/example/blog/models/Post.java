package com.example.blog.models;


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

    @Column(name = "post_name", nullable = false)
    private String postName;

    @Column(name = "post_status", nullable = false)
    private String postStatus;
}
