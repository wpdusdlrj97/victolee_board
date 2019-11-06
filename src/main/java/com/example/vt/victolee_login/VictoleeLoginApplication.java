package com.example.vt.victolee_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VictoleeLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(VictoleeLoginApplication.class, args);
    }

}
