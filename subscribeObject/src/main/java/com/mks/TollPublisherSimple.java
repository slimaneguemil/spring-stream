package com.mks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import java.time.LocalDateTime;

//@EnableBinding(Source.class)
public class TollPublisherSimple {

        @InboundChannelAdapter(channel = Source.OUTPUT)
        public String sendTollcharge() {
            return "{station:\""+ LocalDateTime.now()+"\"}";
        }
}
