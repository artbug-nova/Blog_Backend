package com.example.blog.controllers;

import com.example.blog.dto.AuthRequest;
import com.example.blog.models.User;
import com.example.blog.modelui.UserUi;
import com.example.blog.service.SecurityService;
import com.example.blog.service.UserService;
import com.example.blog.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final SecurityService securityService;

    private final UserDetailsService userDetailsService;

    public UserController(SecurityService securityService, UserService userService, @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.securityService = securityService;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/registration")
    public User registration(@RequestBody User userRequset) throws Exception {
        userService.save(userRequset);
        return userRequset;
    }


    @PostMapping("/login")
    public User login(@RequestBody User userRequest){
        UserDetails userDetails = userDetailsService.loadUserByUsername(userRequest.getUserName());
        return userRequest;
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

    @GetMapping("/getuser")
    public UserUi get(String name){
        User user = userService.findByuserName(name);
        UserUi userUi = new UserUi();
        userUi.setUserName(user.getUserName());
        userUi.setPassword(user.getPassword());
        return userUi;
    }
}