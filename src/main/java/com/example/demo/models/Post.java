package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long Id;

    @Column(name = "post_name", nullable = false)
    private String postName;

    @Column(name = "post_status", nullable = false)
    private String postStatus;


    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

}
