package com.codeando.postapi.controllers;

import com.codeando.postapi.dto.responses.ErrorResponseBody;
import com.codeando.postapi.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class HandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception,
                                             WebRequest request,
                                             HttpServletResponse response) {
        log.error(exception);
        return handleExceptionInternal(exception,new ErrorResponseBody("Error inesperado.") , new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception,
                                                          WebRequest request,
                                                          HttpServletResponse response) {
        log.error(exception);
        return handleExceptionInternal(exception,new ErrorResponseBody(exception.getMessage()) , new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
