package com.codeando.postapi.controllers;

import com.codeando.postapi.dto.requests.UserCreateDto;
import com.codeando.postapi.dto.responses.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid request, userId inválido."),
            @ApiResponse(responseCode = "404", description = "No se encontró el usuario con el id especificado.")
    })
    @Operation(summary = "Obtiene un usuario por su id")
    UserResponseDto findById(String userId);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid request, error en los parametros de entrada.")
    })
    @Operation(summary = "Obtiene todos los usuarios paginados")
    Page<UserResponseDto> findAll(Pageable pageable);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Creado"),
            @ApiResponse(responseCode = "400", description = "Invalid request, error en los parametros de entrada."),
            @ApiResponse(responseCode = "409", description = "El usuario ya existe.")
    })
    @Operation(summary = "Crea un nuevo usuario y lo persiste en la BD")
    @ResponseStatus(HttpStatus.CREATED)
    UserResponseDto createUser(@RequestBody UserCreateDto userCreateDto);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Invalid request, error en los parametros de entrada.")
    })
    @Operation(summary = "Devuelve los datos del usuario autenticado")
    UserResponseDto getUser();

}
