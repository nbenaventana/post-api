package com.codeando.postapi.services.implementations;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import com.codeando.postapi.repository.UserRepository;
import com.codeando.postapi.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.codeando.postapi.mappers.UserMapper;

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
        return mapper.toDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public Page<UserResponseDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public UserResponseDto createUser(UserCreateDto dto) {
        return mapper.toDto(repository.save(mapper.toUser(dto)));
    }
}
