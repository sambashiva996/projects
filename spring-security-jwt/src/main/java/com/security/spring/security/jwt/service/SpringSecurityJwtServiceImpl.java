package com.security.spring.security.jwt.service;

import com.security.spring.security.jwt.model.UserDTO;
import com.security.spring.security.jwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class SpringSecurityJwtServiceImpl implements SpringSecurityJwtService{
   @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;

//    public SpringSecurityJwtServiceImpl(JwtUtils jwtUtils, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
//        this.jwtUtils = jwtUtils;
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//    }

    @Override
    public String generateToken(UserDTO userDTO) {
        String userName = userDTO.getUserName();
        String password = userDTO.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        return jwtUtils.generateToken(userDetails.getUsername());
    }
}
