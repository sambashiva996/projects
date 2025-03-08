package com.spring.security.spring.security.jwt.token.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloSecurity(HttpServletRequest httpServletRequest){
        return "Hello Security"+httpServletRequest.getSession().getId();
    }
}
