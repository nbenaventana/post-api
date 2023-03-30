package com.codeando.postapi.services.implementations;

import com.codeando.postapi.dto.responses.PostResponseDto;
import com.codeando.postapi.entity.Post;

import com.codeando.postapi.entity.User;
import com.codeando.postapi.repository.PostRepository;
import com.codeando.postapi.services.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post createPost(Post post) {
        return repository.save(post);
    }

    @Override
    public Page<Post> findAllByUser(User user, Pageable pageable) {
        return repository.findAllByUserOrderByCreatedAtDesc(user, pageable);
    }
}
