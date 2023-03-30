package com.codeando.postapi.services;

import com.codeando.postapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
        User findById(UUID id);

        Page<User> findAll(Pageable pageable);

        User createUser(User user);

        User findByEmail(String email);

}
