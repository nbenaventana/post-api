package com.codeando.postapi.services.implementations;

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

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No se encontró el usuario con id: " + id));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User createUser(User user) {
        if (repository.existsByEmail(user.getEmail()))
            throw new UserEmailAlreadyExist("Ya existe un usuario con el email: " + user.getEmail());

        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("No se encontró el usuario con email: " + email));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.codeando.postapi.entity.User userEntity = repository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("No se encontró el usuario con email: " + email));

        return new org.springframework.security.core.userdetails.User(
                userEntity.getEmail(), userEntity.getPassword(), new ArrayList<>());
    }
}
