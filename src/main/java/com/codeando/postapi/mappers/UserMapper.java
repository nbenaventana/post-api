package com.codeando.postapi.mappers;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import com.codeando.postapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        UserResponseDto toDto(User user);

        User toUser(UserCreateDto userCreateDto);

}
