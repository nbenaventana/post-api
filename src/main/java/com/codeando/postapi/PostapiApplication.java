package com.codeando.postapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostapiApplication.class, args);
    }

}
