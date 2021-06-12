package com.jong960107.web04_self3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class Web04Self3Application {

    public static void main(String[] args) {
        SpringApplication.run(Web04Self3Application.class, args);
    }

}
