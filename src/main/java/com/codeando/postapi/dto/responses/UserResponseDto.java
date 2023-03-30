package com.codeando.postapi.dto.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

}
