package com.mks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Publisher;
import org.springframework.stereotype.Service;



@Service
public class ExampleService {

    @Publisher(channel = ExampleBindings.OUTPUT)
    public String queue(String message){
        return message;
    }

/*    @StreamListener(ExampleBindings.INPUT)
    public void dequeue22(String message){
        System.out.println("New message: " + message);
    }*/


}