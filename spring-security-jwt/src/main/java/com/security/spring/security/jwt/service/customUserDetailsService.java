package com.security.spring.security.jwt.service;

//import com.security.spring_security_jwt.entity.UserDetailsData;
//import com.security.spring_security_jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class customUserDetailsService implements UserDetailsService {

//    @Autowired
//    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        UserDetailsData userDetailsData = userRepository.findByUserName(username).orElseThrow(() -> new UserDataException("user not found"));
        if ("user".equals(username)){
        return new User(username, passwordEncoder.encode("password"), new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
