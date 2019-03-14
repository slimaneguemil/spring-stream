package com.mks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RestProducing {

    private final MessageChannel broadcast;

    // <2>
    @Autowired
    RestProducing(ConsumerChannels channels) {
        this.broadcast = channels.output_channel();
    }

    @RequestMapping("/hi/{name}")
    String hi(@PathVariable String name) {
        String message = "{\"stationId\":\"30\",\"customeId\":\"30\",\"timestamp\":\"now\"}";

        System.out.println("received from rest :"+ message);
        // <3>

        Foo foo1 = new Foo();
        foo1.setId(100);
        foo1.setName("Foobar");
        foo1.setTag("1");

        this.broadcast.send(MessageBuilder.withPayload(
                foo1
        )
                .build());
        return "//nSuccess";
    }
}

