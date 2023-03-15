package com.codeando.postapi.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionUtil {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encrypt(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
