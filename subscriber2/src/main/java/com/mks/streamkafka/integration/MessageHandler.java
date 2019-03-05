package com.mks.streamkafka.integration;

import com.mks.streamkafka.message.InputChannel;
import com.mks.streamkafka.model.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@EnableBinding(InputChannel.class)
public class MessageHandler {
/*
    @StreamListener(Sink.INPUT)
    public void handle(String message) {
        log.info("message received {}", message);
        System.out.println(message);
    }*/


   @StreamListener(Sink.INPUT)
    public void handle(@Payload Greetings greetings) {
        log.info("message received {}", greetings);
        System.out.println(greetings);
    }


}
