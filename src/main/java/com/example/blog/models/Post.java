package com.example.blog.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "post_name", nullable = false)
    private String postName;

    @Column(name = "post_status", nullable = false)
    private String postStatus;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "posts_likes",
            joinColumns = { @JoinColumn(name = "posts_id") },
            inverseJoinColumns = { @JoinColumn(name = "likes_id") }
    )
    private Set<Like> likes = new HashSet<>();
}
