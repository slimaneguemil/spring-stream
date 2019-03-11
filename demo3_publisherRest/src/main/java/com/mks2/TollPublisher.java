package com.mks2;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TollSource.class)
public class TollPublisher {
}
