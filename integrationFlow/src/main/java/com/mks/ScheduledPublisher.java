package com.mks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledPublisher {

    private ConsumerChannels customProcessor;


    @Autowired //Always, always, always autowire via constructor
    public ScheduledPublisher(ConsumerChannels customProcessor) {
        this.customProcessor = customProcessor;
    }

    //Every 1000ms this method will be executed
    @Scheduled(fixedDelayString = "1000")
    public void pollMessages() {
        Log log = LogFactory.getLog(getClass());
        boolean hasMessage = true;

        //checking if service is healthy
           // while (hasMessage) {
                log.info("Sending new message ....");
                this.customProcessor.output_channel().send(MessageBuilder.withPayload("Broadcast: " + LocalDateTime.now())
                        .build());
           // }
        }

}