package com.mks2;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TollSource {
	
	@Output("fastpassTollChannel")
	MessageChannel fastpassToll();
	
	@Output("standardTollChannel")
	MessageChannel standardToll();

	@Input("pollChannel")
	MessageChannel pollToll();
}
