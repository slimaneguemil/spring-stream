package com.mks;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {


 String OUTPUT_CHANNEL1 = "output_channel1";


 @Output(OUTPUT_CHANNEL1)
 MessageChannel output_channel();

}
