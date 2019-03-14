package com.mks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Producing {

    private final MessageChannel broadcast;

    // <2>
    @Autowired
    Producing(ConsumerChannels channels) {
        this.broadcast = channels.output_channel();
    }

    @RequestMapping("/hi/{name}")
    String hi(@PathVariable String name) {
        String message = "Hello, " + name + "!";

        System.out.println("received from rest :"+ message);
        // <3>

        this.broadcast.send(MessageBuilder.withPayload("Broadcast: " + message)
                .build());
        return "//nSuccess";
    }
}

