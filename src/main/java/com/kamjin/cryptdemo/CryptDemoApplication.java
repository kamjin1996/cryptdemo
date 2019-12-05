package com.kamjin.cryptdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CryptDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptDemoApplication.class, args);
    }
}
