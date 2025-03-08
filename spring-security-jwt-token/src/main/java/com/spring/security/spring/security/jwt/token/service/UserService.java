package com.spring.security.spring.security.jwt.token.service;

import com.spring.security.spring.security.jwt.token.entity.Users;
import com.spring.security.spring.security.jwt.token.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRepo usersRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public Users register(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return usersRepo.save(users);
    }

    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    public Users deleteUser(Users users) {
        Users byUsername = usersRepo.findByUsername(users.getUsername());
        usersRepo.delete(byUsername);
        return byUsername;
    }

    public String verify(Users user) {

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authenticate.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "fail";
    }
}
