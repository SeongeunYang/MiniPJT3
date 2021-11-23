package com.diddl.minipjt3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MiniPjt3Application {
    public static void main(String[] args) {
        SpringApplication.run(MiniPjt3Application.class, args);
    }
}
