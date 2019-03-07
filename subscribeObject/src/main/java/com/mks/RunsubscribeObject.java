package com.mks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
//@EnableBinding(Sink.class)
@SpringBootApplication
public class RunsubscribeObject {

    public static void main(String[] args){
        SpringApplication.run(RunsubscribeObject.class, args);
    }


    //@StreamListener(Sink.INPUT)
    @StreamListener(target=Sink.INPUT, condition="headers['speed']>20")
    public void sinkLogFast(String message)
    {
        System.out.println("receiving hedaer=fast :" +message);
    }
    @StreamListener(target=Sink.INPUT, condition="headers['speed']<=10")
    public void sinkLogLow(final Message<String> message)
    {
        System.out.println("receiving header=low :" +message);
    }


/*
    @ServiceActivator(inputChannel = Sink.INPUT)
    public void activatorLog(String message)
    {
        System.out.println("receiving by ServiceActivatormessage :" +message);
    }*/

/*    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String processorLog(String message){
        System.out.println("receiving message  by Processor:" +message);
        return message;
    }*/


}
