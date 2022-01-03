package com.example.blog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_like")
    private String name;

    @Column(name = "author_like")
    private String author;

    @ManyToMany(mappedBy = "likes")
    @JsonBackReference
    private Set<Post> posts = new HashSet<>();
}
