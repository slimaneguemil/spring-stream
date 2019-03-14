package com.mks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;


@SpringBootApplication
//@EnableScheduling
public class RunIntegrationFlow {

    public static void main(String args[]) {
        SpringApplication.run(RunIntegrationFlow.class, args);
    }


    private IntegrationFlow incomingMessageFlow(SubscribableChannel incoming,
                                                String prefix) {

        Log log = LogFactory.getLog(getClass());

        return IntegrationFlows
                .from(incoming)
                .transform(Transformers.objectToString())
                .transform(String.class, String::toUpperCase)
                .handle(
                        String.class,
                        (greeting, headers) -> {
                            log.info("solution 2  (" + prefix + "): "
                                    + greeting);
                            return null;
                        }).get();
    }

    //@Bean
    IntegrationFlow broadcast(ConsumerChannels channels) {
        return incomingMessageFlow(channels.input_channel(), "broadcast");
    }

    @StreamListener(ConsumerChannels.INPUT_CHANNEL1)
    public void receiveing(Foo message){
        System.out.println("streamlistener message="+ message.getName());
    }
   /* @InboundChannelAdapter(channel = ConsumerChannels.OUTPUT_CHANNEL1)
    public String sendTollcharge() {

        System.out.println("sending data");
        return "{station:\""+ LocalDateTime.now()+"\"" +
                "}";
    }*/

    @Bean
    @InboundChannelAdapter(channel = ConsumerChannels.OUTPUT_CHANNEL1, poller = @Poller(fixedDelay = "1000"))
    public MessageSource<Foo> sendTestData() {
        Foo foo1 = new Foo();
        foo1.setId(100);
        foo1.setName("Foobar");
        foo1.setTag("1");

        Foo foo2 = new Foo();
        foo2.setId(200);
        foo2.setName("BarFoo");
        foo2.setTag("2");

        return () ->
                new GenericMessage<>(foo2);
    }


    @Bean
    public ApplicationRunner runner(PollableMessageSource input) {
        return args -> {
            System.out.println("Send some messages to topic polledConsumerIn and receive from polledConsumerOut");
            System.out.println("Messages will be processed one per second");
            exec.execute(() -> {
                boolean result = false;
                while (true) {
                    // this is where we poll for a message, process it, and send a new one
                    result = input.poll(m -> {
                        String payload = (String) m.getPayload();
                        System.out.println("Received: " + payload);

                    }, new ParameterizedTypeReference<String>() { });

                    try {
                        Thread.sleep(1_000);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    if (result) {
                        System.out.println("Success");
                    }
                }
            });
        }


}