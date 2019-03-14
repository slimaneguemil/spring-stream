package com.mks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

//@EnableBinding(InputChannels.class)
public interface InputChannels {

    @Input
    SubscribableChannel rick();
}
