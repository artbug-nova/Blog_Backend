package com.example.blog.models;


import io.swagger.annotations.ApiModelProperty;
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
    private Long Id;

    @ApiModelProperty(value = "Имя лайка", example = "Имя дайка")
    @Column(name = "name_like")
    private String Name;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = true)
    private Post post;

}
