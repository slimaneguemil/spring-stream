package com.mks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(RickChannels.class)
public interface RickChannels {

	@Input
    SubscribableChannel rick();

	@Output
    MessageChannel meeseeks();

	@Output
    MessageChannel microverse();
}
