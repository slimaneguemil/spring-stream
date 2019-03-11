package com.mks2;

import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.StringJoiner;


@RestController
@SpringBootApplication
public class RunDemo3Test {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	private TollSource source;

	public RunDemo3Test (TollSource source) {
		this.source = source;
	}

	public static void main(String[] args) {
		SpringApplication.run(RunDemo3Test.class, args);
	}

	//@PostMapping()
	@RequestMapping(path="/toll2", method= RequestMethod.POST)
	public String sendMessage(@RequestBody Toll incomming) {
		Toll personEvent = new Toll("1","2","3");
//		Toll personEvent = new Toll(incomming.getCustomerId(),incomming.getCustomerId(),"3");

		source.fastpassToll().send(MessageBuilder.withPayload(incomming).build());
		logger.info("toll sendt={}", personEvent);

		//source.fastpassToll().send(MessageBuilder.withPayload(incomming).build());
		logger.info("Incomnig sendt={}", incomming);
		return "Person sendt";
	}


}
