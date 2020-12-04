package com.example.blog.models;

import com.example.blog.constants.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "role_name", nullable = false)
    //@Enumerated(EnumType.STRING)
    private String Name;
}
