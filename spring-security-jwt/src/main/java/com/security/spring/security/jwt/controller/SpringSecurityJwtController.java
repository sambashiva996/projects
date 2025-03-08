package com.security.spring.security.jwt.controller;

import com.security.spring.security.jwt.model.UserDTO;
import com.security.spring.security.jwt.service.SpringSecurityJwtService;
import com.security.spring.security.jwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpringSecurityJwtController {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping(name = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(@RequestBody UserDTO userDTO){
        String userName = userDTO.getUserName();
        String password = userDTO.getPassword();
//
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        return ResponseEntity.ok().body(jwtUtils.generateToken(userName));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("success");
    }

}
