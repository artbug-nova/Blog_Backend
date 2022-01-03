package com.example.blog.service;


import com.example.blog.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role getById(Long id);
    Role save(Role role);
    Role update(Role role);
    void delete(Long id);
}
