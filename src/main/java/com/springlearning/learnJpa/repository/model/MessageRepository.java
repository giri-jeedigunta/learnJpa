package com.springlearning.learnJpa.repository.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    List<Message> findTop200ByStatusAndDomainOrderByCreatedTsAsc(String status, String domain);
}
