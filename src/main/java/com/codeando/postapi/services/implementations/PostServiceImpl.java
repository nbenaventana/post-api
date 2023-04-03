package com.codeando.postapi.services.implementations;

import com.codeando.postapi.entity.Exposure;
import com.codeando.postapi.entity.Post;

import com.codeando.postapi.entity.User;
import com.codeando.postapi.exceptions.EntityNotFoundException;
import com.codeando.postapi.exceptions.UserNotAllowedException;
import com.codeando.postapi.repository.ExposureRepository;
import com.codeando.postapi.repository.PostRepository;
import com.codeando.postapi.services.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Log4j2
@Service
public class PostServiceImpl implements PostService {
    private final ExposureRepository exposureRepository;

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository,
                           ExposureRepository exposureRepository) {
        this.repository = repository;
        this.exposureRepository = exposureRepository;
    }

    @Override
    public Post createPost(Post post) {
        return repository.save(post);
    }

    @Override
    public Page<Post> findAllByUser(User user, Pageable pageable) {
        return repository.findAllByUserOrderByCreatedAtDesc(user, pageable);
    }

    @Override
    public Page<Post> findLastPublic(Exposure exposure, Pageable pageable) {
        return repository.findAllByExposureOrderByCreatedAtDesc(
                exposure,
                new Date(System.currentTimeMillis())
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime() ,
                pageable);
    }

    @Override
    public void deletePost(UUID postId, UUID userId) {
        Post post = repository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró post con el id: " + postId));

        if (!post.getUser().getId().equals(userId)) {
            throw new UserNotAllowedException("El usuario no tiene permisos para eliminar este post");
        }

        repository.delete(post);

    }

    @Override
    public Post modifyPost(UUID postId, UUID userId, Post post) {
        Post actual = repository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró post con el id: " + postId));

        if (!actual.getUser().getId().equals(userId)) {
            throw new UserNotAllowedException("El usuario no tiene permisos para modificar este post");
        }

        Exposure exposure = exposureRepository.findById(post.getExposure().getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró exposición con el id: " + post.getExposure().getId()));

        post.setUser(actual.getUser());
        post.setExposure(exposure);

        return repository.save(post);

    }

}
