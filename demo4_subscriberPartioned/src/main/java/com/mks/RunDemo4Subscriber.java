package com.mks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.event.ListenerContainerIdleEvent;

@EnableBinding(Sink.class)
@SpringBootApplication
public class RunDemo4Subscriber implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RunDemo4Subscriber.class, args);


		System.out.println("t************************** debug1 !!!");

	}

	//@StreamListener(target=Sink.INPUT, condition="headers['speed'] > 40")
	public void logfast(String msg) {
		System.out.println("fast = " + msg);
		//return msg;
	}
	
	//@StreamListener(target=Sink.INPUT, condition="headers['speed'] <= 40")
	public void logslow(String msg) {
		System.out.println("slow = " + msg);
		//return msg;
	}


		@Override
		public void run(String... String) {
		System.out.println("t************************** debug2");
		}





}
