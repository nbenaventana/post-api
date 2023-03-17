package com.codeando.postapi.config.security;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
    public static final Long EXPIRATION_TIME = 864000000L;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static final String SIGN_UP_URL = "/users";

    @Value("${security.token_secret}")
    public static final String TOKEN_SECRET = "M8hSAIR9gSahUyFED3Ife2ktORagTNae";
}