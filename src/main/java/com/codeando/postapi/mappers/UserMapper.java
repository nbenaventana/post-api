package com.codeando.postapi.mappers;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import com.codeando.postapi.util.EncryptionUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", imports = {EncryptionUtil.class})
public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        UserResponseDto toDto(com.codeando.postapi.entity.User user);

        @Mapping(target = "password", expression = "java(EncryptionUtil.encrypt(userCreateDto.getPassword()))")
        com.codeando.postapi.entity.User toUser(UserCreateDto userCreateDto);

}
