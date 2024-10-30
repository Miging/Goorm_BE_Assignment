package com.example.goorm_be_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GoormBeAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoormBeAssignmentApplication.class, args);
    }

}
