package com.mks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//@EnableBinding(OutputChannels.class)
public interface OutputChannels {

	@Output
    MessageChannel microverse();
}
