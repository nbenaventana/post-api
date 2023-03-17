package com.codeando.postapi.services.implementations;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import com.codeando.postapi.entity.User;
import com.codeando.postapi.exceptions.EntityNotFoundException;
import com.codeando.postapi.exceptions.UserEmailAlreadyExist;
import com.codeando.postapi.exceptions.UsernameNotFoundException;
import com.codeando.postapi.repository.UserRepository;
import com.codeando.postapi.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.codeando.postapi.mappers.UserMapper;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper = UserMapper.INSTANCE;

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponseDto findById(UUID id) {
        return mapper.toDto(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No se encontró el usuario con id: " + id)));
    }

    @Override
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public UserResponseDto createUser(UserCreateDto dto) {
        if (repository.existsByEmail(dto.getEmail()))
            throw new UserEmailAlreadyExist("Ya existe un usuario con el email: " + dto.getEmail());

        return mapper.toDto(repository.save(mapper.toUser(dto)));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userEntity = repository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("No se encontró el usuario con email: " + email));

        return new org.springframework.security.core.userdetails.User(
                userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
    }
}
