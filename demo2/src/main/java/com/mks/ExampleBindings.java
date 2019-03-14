package com.mks;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

//@EnableBinding(ExampleBindings.class)
public interface ExampleBindings {

    String INPUT = "input1";
    String OUTPUT = "output1";

  //  @Input(ExampleBindings.INPUT)
  //  SubscribableChannel input();

    @Output(ExampleBindings.OUTPUT)
    MessageChannel output();
}