package com.springlearning.learnJpa.service;

import com.springlearning.learnJpa.repository.model.Message;
import com.springlearning.learnJpa.repository.model.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Message> fetchMessages(String domain) {
        return repository.findTop200ByStatusAndDomainOrderByCreatedTsAsc("I", domain);
    }
}
