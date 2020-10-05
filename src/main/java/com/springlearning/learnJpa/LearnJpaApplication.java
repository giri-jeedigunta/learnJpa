package com.springlearning.learnJpa;

import com.springlearning.learnJpa.processor.MessageManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class LearnJpaApplication {
	private final ApplicationContext context;
	private final MessageManager messageManager;

	@Autowired
	public LearnJpaApplication(ApplicationContext context, MessageManager messageManager) {
		this.context = context;
		this.messageManager = messageManager;

		messageManager.setApplicationContext(context);
		messageManager.run("product");
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnJpaApplication.class, args);
	}
}