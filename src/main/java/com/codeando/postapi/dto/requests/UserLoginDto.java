package com.codeando.postapi.dto.requests;

import lombok.Data;

@Data
public class UserLoginDto {
    private String email;
    private String password;
}
