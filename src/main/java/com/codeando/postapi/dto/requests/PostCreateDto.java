package com.codeando.postapi.dto.requests;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PostCreateDto {

    private String title;

    private String content;

    private int expirationTime;

    private Long exposureId;

}
