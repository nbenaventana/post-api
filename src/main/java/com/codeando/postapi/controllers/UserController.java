package com.codeando.postapi.controllers;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserController {

    UserResponseDto findById(String userId);

    Page<UserResponseDto> findAll(Pageable pageable);

    UserResponseDto createUser(@RequestBody UserCreateDto userCreateDto);

}
