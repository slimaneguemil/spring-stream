package com.mks;
// lombok autogenerates getters, setters, toString() and a builder (see https://projectlombok.org/):
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@EnableBinding(TollSource.class)
public class TollPublisher {

    Random r = new Random();
    @Bean
    @InboundChannelAdapter(channel="fastpassTollChannel", poller=@Poller(fixedDelay = "2000"))
    //@InboundChannelAdapter(channel="fastpassTollChannel")
    public MessageSource<Toll> standardPoll(){
    /*    return () -> MessageBuilder.withPayload(
                new Toll("20","100",LocalDateTime.now().toString()))
                .setHeader("speed",60)
                .build();*/
       // Random r = new Random();
        //int rd = r.nextInt(8) * 10;
        int rd = ThreadLocalRandom.current().nextInt(0,8)*10;
        System.out.println("rd:"+rd);
        return () -> MessageBuilder.withPayload(new Toll("200",rd,"2017-07-12T12:04:00")).setHeader("speed", rd).build();

    }

 /*   @Getter
    @Setter
    class Toll{
        public String stationId;
        public String customeId;
        public String timestamp;

        public Toll(String _stationId, String _customerId, String _timestamp){
            this.stationId = _stationId;
            this.customeId = _customerId;
            this.timestamp = _timestamp;
        }
    }*/
}
