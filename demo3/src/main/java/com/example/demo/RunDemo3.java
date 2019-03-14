package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //Enables Spring's scheduled task execution capability
public class RunDemo3 {

    public static void main(String[] args) {
        SpringApplication.run(RunDemo3.class, args);
    }
}