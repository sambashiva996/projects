package com.security.spring.security.jwt.service;

import com.security.spring.security.jwt.model.UserDTO;

public interface SpringSecurityJwtService {
    String generateToken(UserDTO userDTO);
}
