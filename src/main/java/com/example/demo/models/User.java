package com.example.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "user_name", nullable = false)
    private String UserName;
    @Column(name = "password", nullable = false)
    private String Password;

    @Transient
    private String PasswordConfirm;

    @OneToMany
    @JoinColumn(name = "role_id", nullable = true)
    private Role role;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPasswordConfirm() {
        return PasswordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        PasswordConfirm = passwordConfirm;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

}
