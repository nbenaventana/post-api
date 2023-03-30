package com.codeando.postapi.controllers;

import com.codeando.postapi.dto.requests.PostCreateDto;
import com.codeando.postapi.dto.responses.PostResponseDto;
import com.codeando.postapi.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creado"),
            @ApiResponse(responseCode = "400", description = "Error en los parametros de entrada.")
    })
    @Operation(summary = "Crea un nuevo post donde el tiempo de expiración esta en minutos.")
    public PostResponseDto createPost(@RequestBody PostCreateDto dto);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Error en los parametros de entrada.")
    })
    @Operation(summary = "Obtiene todos los posts de un usuario.")
    public Page<PostResponseDto> findAllByUser(Pageable pageable);

}
