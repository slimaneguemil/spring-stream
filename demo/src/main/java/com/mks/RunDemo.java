package com.mks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

//@EnableBinding(Sink.class)
@SpringBootApplication
public class RunDemo implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RunDemo.class, args);
		System.out.println("t************************** debug1 !!!");
	}

		@Override
		public void run(String... String) {
		System.out.println("t************************** debug2");
		}



}
