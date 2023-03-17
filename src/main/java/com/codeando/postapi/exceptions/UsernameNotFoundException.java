package com.codeando.postapi.exceptions;

public class UsernameNotFoundException extends PostApiException{
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
