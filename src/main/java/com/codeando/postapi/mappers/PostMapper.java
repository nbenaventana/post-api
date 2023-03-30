package com.codeando.postapi.mappers;

import com.codeando.postapi.dto.requests.PostCreateDto;
import com.codeando.postapi.dto.responses.PostResponseDto;
import com.codeando.postapi.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Mapper(componentModel = "spring", imports = {Date.class, ZoneId.class, LocalDateTime.class})
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "expirationDate",
            expression = "java(new Date(System.currentTimeMillis() + (dto.getExpirationTime() * 60000))" +
                    ".toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())")
    @Mapping(source = "dto.exposureId", target = "exposure.id")
    Post toPost(PostCreateDto dto);

    @Mapping(target = "isExpired", expression = "java(post.getExpirationDate().isBefore(LocalDateTime.now()))")
    PostResponseDto toDto(Post post);

}
