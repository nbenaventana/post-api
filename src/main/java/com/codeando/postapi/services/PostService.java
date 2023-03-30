package com.codeando.postapi.services;

import com.codeando.postapi.dto.responses.PostResponseDto;
import com.codeando.postapi.entity.Post;
import com.codeando.postapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;

public interface PostService {

    public Post createPost(Post post);

    Page<Post> findAllByUser(User user, Pageable pageable);

}
