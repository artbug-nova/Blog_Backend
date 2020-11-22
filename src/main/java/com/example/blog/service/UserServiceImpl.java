package com.example.blog.service;

import com.example.blog.repository.RoleRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.models.Role;
import com.example.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void save(User user)  {
        try{
            int a = 1;
            Long id = (long)a;
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            Role role = roleRepository.findById(id).orElseThrow(()-> new Exception());
            user.setRole(role);
            userRepository.save(user);

        }
        catch (Exception exp){

        }

    }

    @Override
    public User findByuserName(String userName) {
        return userRepository.findByuserName(userName);
    }
}
