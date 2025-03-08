package com.spring.security.spring.security.jwt.token.controller;

import com.spring.security.spring.security.jwt.token.entity.Users;
import com.spring.security.spring.security.jwt.token.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user")
    Users deletedUser(Users user){
        return userService.deleteUser(user);
    }
}
