package com.spring.security.spring.security.jwt.token.repo;

import com.spring.security.spring.security.jwt.token.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
