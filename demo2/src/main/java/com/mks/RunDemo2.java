package com.mks;

import org.springframework.amqp.rabbit.listener.ListenerContainerIdleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@EnableBinding(Sink.class)
@SpringBootApplication
public class RunDemo2 {

    //@Autowired
    //private static ExampleService exampleService;

    public static void main(String[] args) {
        SpringApplication.run(RunDemo2.class, args);
        System.out.println("t************************** debug1 !!!");

       //exampleService.queue("Hello");

    }


  //  @StreamListener(target=Sink.INPUT)
    public void logslow(String msg) {
        System.out.println("slow = " + msg);
        //return msg;
    }

    @Bean
    public ApplicationListener<ListenerContainerIdleEvent> idleListener() {
        return event -> {
            System.out.println("------------------------------------------------------------"+event);
            System.out.println("------------------------------------------------------------");
            System.out.println("------------------------------------------------------------");

        };
    }


}
