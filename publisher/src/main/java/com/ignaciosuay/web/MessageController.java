package com.ignaciosuay.web;

import com.ignaciosuay.message.OutputChannel;
import com.ignaciosuay.model.Greetings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {

    private final OutputChannel channel;

    @RequestMapping(method = RequestMethod.GET, value = "/sendMessage/{message}")
    public String sendMessage(@PathVariable String message) {
        log.info("controller sendMEssage : Receive message {}", message);
        Message<String> msg = MessageBuilder.withPayload(message).build();
        channel.output().send(msg);
        return "Message " + message + " sent to the subscribers";
    }

    @GetMapping("/greetings")
    public String sendGreetings(@RequestParam("message") String message) {
        log.info("controler greetings : Receive message {}", message);
        Greetings greetings = Greetings.builder()
                .message(message)
                .message2("this is a test")
                .timestamp(System.currentTimeMillis())
                .build();
        channel.output().send(MessageBuilder
                .withPayload(greetings)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
        return "Message " + message + " sent to the subscribers";
    }

}
