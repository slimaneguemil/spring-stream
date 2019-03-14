package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FastPassRestController {

	@Autowired
	TollSource mysource;
	
	@RequestMapping(path="/toll", method=RequestMethod.POST)
	public String publishMessage(@RequestBody String payload) {

		System.out.println("in rest controller payload: "+ payload);

		Random r = new Random();
		mysource.fastpassToll().send(MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt(8) * 10).build());
		
		return "success";
	}

}
