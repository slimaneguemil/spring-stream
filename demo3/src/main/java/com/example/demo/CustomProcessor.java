package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

public interface CustomProcessor {
    String POLLABLE_INPUT = "pollableInput";
    //Define our own message source, from where we are going to pull/poll our messages.
    //Pls note that it is an "Input" type, e.g. read only, no writes to this "channel"
    @Input(CustomProcessor.POLLABLE_INPUT)
    PollableMessageSource pollableInput();


    @Input(CustomProcessor.POLLABLE_INPUT)
    SubscribableChannel subscribeInput();
}