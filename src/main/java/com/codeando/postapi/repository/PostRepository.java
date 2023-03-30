package com.codeando.postapi.repository;

import com.codeando.postapi.entity.Post;
import com.codeando.postapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    Page<Post> findAllByUserOrderByCreatedAtDesc(User user, Pageable pageable);

}
