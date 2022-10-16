package com.raiseup.MessagingwithRedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class MessagingwithRedisApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessagingRedisApplication.class);

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx =
				SpringApplication.run(MessagingwithRedisApplication.class, args);
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		Receiver receiver = ctx.getBean(Receiver.class);

		while (receiver.getCount() == 0) {

			LOGGER.info("Sending message...");
			template.convertAndSend("chat", "Hello from Redis!");
			Thread.sleep(500L);
		}

		System.exit(0);
	}

}
