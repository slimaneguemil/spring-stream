package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
//Our fake service
public class ExternalService {

    public boolean isHealthy() {
        //Imagine we are checking health of external web service
        return ThreadLocalRandom.current().nextBoolean();
    }

    public void enrichData(String message) {
        //Sending data to external service
    }
}