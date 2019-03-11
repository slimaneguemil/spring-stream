/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.mks2.TollSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;

import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.cloud.stream.test.matcher.MessageQueueMatcher.receivesPayloadThat;

/**
 * The Spring Boot-base test-case to demonstrate how can we test Spring Cloud Stream applications
 * with available testing tools.
 *
 * @author Artem Bilan
 *
 */

@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
public class FooBarSourceTests {

	@Autowired
	//private Source channels;
	private TollSource source;

	@Autowired
	private Source channels;


	@Autowired
	private MessageCollector collector;

	//@Test
	public void testMessages() {
		MessageChannel input = this.source.fastpassToll();
		input.send(new GenericMessage<>("foo"));
	}


	@Test
	@SuppressWarnings("unchecked")
	public void testSlim(){
		Toll toll= new Toll("3","2","1");
		source.fastpassToll().send(MessageBuilder.withPayload(toll).build());
		BlockingQueue<Message<?>> messages = this.collector.forChannel(channels.output());

		assertThat(messages, receivesPayloadThat(is("poll")));
	}
}
