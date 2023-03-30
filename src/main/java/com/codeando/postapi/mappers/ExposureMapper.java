package com.codeando.postapi.mappers;

import com.codeando.postapi.dto.responses.ExposureResponseDto;
import com.codeando.postapi.entity.Exposure;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExposureMapper {

    ExposureMapper INSTANCE = Mappers.getMapper(ExposureMapper.class);

    ExposureResponseDto toDto(Exposure exposure);

}
