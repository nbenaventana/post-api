package com.codeando.postapi.dto.responses;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostResponseDto {

    private UUID id;

    private String title;

    private String content;

    private LocalDateTime expirationDate;

    private LocalDateTime createdAt;

    private UserResponseDto user;

    private ExposureResponseDto exposure;

    private Boolean isExpired;

}
