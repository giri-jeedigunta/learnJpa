package com.springlearning.learnJpa.processor;

import com.springlearning.learnJpa.repository.model.Message;
import com.springlearning.learnJpa.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@EnableAsync
@EnableScheduling
@Slf4j
@Component
public class MessageManager implements ApplicationContextAware {
    private final MessageService messageService;
    private ApplicationContext context;

    public MessageManager(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Async
    public void run(String domainName) {
        try {
            while (true) {
                List<Message> messages = messageService.fetchMessages(domainName);
                if (messages.isEmpty()) {
                    log.info("Sleeping for 10 seconds as no messages were found in the last poll");
                    Thread.sleep(TimeUnit.SECONDS.toMillis(10));
                } else {
                    try {
                        System.out.println("Messages Retrieved !!!");
                    } catch (Exception e) {
                        log.error("Failed retrieving messages", e);
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            log.error("Unhandled error in message producer...exiting", e);
            SpringApplication.exit(context, () -> 1);
        }
    }
}
