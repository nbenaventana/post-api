package com.codeando.postapi.dto.requests;

import lombok.Data;

@Data
public class PostModifyDto {

    private String title;

    private String content;

    private int expirationTime;

    private Long exposureId;

}
