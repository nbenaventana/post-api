package com.codeando.postapi.repository;

import com.codeando.postapi.entity.Exposure;
import com.codeando.postapi.entity.Post;
import com.codeando.postapi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    Page<Post> findAllByUserOrderByCreatedAtDesc(User user, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.exposure = ?1 and p.expirationDate > ?2 ORDER BY p.createdAt DESC")
    Page<Post> findAllByExposureOrderByCreatedAtDesc(Exposure exposure, LocalDateTime now, Pageable pageable);

}
