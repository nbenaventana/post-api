package com.codeando.postapi.controllers.implementations;

import com.codeando.postapi.controllers.UserController;
import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import com.codeando.postapi.services.UserService;
import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserService service;

    public UserControllerImpl(UserService userService) {
        this.service = userService;
    }

    @Override
    @GetMapping("/{id}")
    public UserResponseDto findById(@Nonnull @PathVariable String id) {
        return service.findById(UUID.fromString(id));
    }

    @Override
    @GetMapping
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserCreateDto dto) {
        return service.createUser(dto);
    }

}
