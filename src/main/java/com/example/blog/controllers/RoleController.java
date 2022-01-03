package com.example.blog.controllers;

import com.example.blog.models.Role;
import com.example.blog.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/role", produces = "application/json")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleRepository) {
        this.roleService = roleRepository;
    }

    @GetMapping("/getAll")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable(value = "id") Long id) {
        return roleService.getById(id);
    }

    @PostMapping("/addRole")
    public Role addLike(@RequestBody Role role){
        return roleService.save(role);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Role> updateLike(@RequestBody Role role) {
        Role roleModel = roleService.update(role);
        return ResponseEntity.ok(roleModel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLike(@PathVariable(value = "id") Long id) {
        roleService.delete(id);
        return "Ok";
    }
}
