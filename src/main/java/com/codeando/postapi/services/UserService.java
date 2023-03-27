package com.codeando.postapi.services;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
        UserResponseDto findById(UUID id);

        Page<UserResponseDto> findAll(Pageable pageable);

        UserResponseDto createUser(UserCreateDto dto);

        UserResponseDto findByEmail(String email);

}
