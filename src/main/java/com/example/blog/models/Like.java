package com.example.blog.models;


import javax.persistence.*;

@Entity
@Table(name = "like_post")
public class Like {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long Id;

    @Column(name = "name_like")
    private String Name;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = true)
    private Post post;

}
