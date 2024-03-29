package com.codeando.postapi.services;

import com.codeando.postapi.dto.responses.PostResponseDto;
import com.codeando.postapi.entity.Exposure;
import com.codeando.postapi.entity.Post;
import com.codeando.postapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;

import java.util.UUID;

public interface PostService {

    public Post createPost(Post post);

    Page<Post> findAllByUser(User user, Pageable pageable);

    Page<Post> findLastPublic(Exposure exposure, Pageable pageable);

    void deletePost(UUID postId, UUID userId);

    Post modifyPost(UUID postId, UUID userId, Post post);

}
