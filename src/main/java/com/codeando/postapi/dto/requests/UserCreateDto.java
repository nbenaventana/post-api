package com.codeando.postapi.dto.requests;

import lombok.Data;

@Data
public class UserCreateDto {
    String firstName;
    String lastName;
    String email;
    String password;

}
