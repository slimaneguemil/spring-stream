package com.mks.streamkafka.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputChannel {

    @Input
    SubscribableChannel input();
}
