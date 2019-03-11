package com.mks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
@SpringBootApplication
public class RunDemo3SubscriberSameGroup {

	public static void main(String[] args) {
		SpringApplication.run(RunDemo3SubscriberSameGroup.class, args);
	}
	
	//@ServiceActivator(inputChannel=Sink.INPUT)
	//@SendTo(Processor.OUTPUT)
	@StreamListener(target=Sink.INPUT, condition="headers['speed'] > 40")
	//@StreamListener(target=Sink.INPUT)
	public void logfast(Message<?> msg) {
		System.out.println("fast = " + msg);
		//return msg;
	}
	
	@StreamListener(target=Sink.INPUT, condition="headers['speed'] <= 40")
	public void logslow(Message<?> msg) {
		System.out.println("slow = " + msg);
		//return msg;
	}
}
