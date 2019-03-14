package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableBinding({CustomProcessor.class})//Here we bind our custom channel
public class PollableMessageSourceRunner {

    private CustomProcessor customProcessor;
    private ExternalService externalService;

    @Autowired //Always, always, always autowire via constructor
    public PollableMessageSourceRunner(CustomProcessor customProcessor, ExternalService externalService) {
        this.customProcessor = customProcessor;
        this.externalService = externalService;
        customProcessor.subscribeInput().subscribe(message-> {
            System.out.println("message payload is ."+ message.getPayload());
           // String str = new String( byte[] message.getPayload(), "UTF-8");
            //Toll t = new Toll((byte[]) message.getPayload());
        });
    }

    //Every 1000ms this method will be executed
   // @Scheduled(fixedDelayString = "1000")



}