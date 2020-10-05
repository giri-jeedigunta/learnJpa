package com.springlearning.learnJpa.repository.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGES")
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    private String domain;

    private String messageKey;

    private String contentType;

    private String status;

    private String producerId;

    @Column(length = 1024 * 1024)
    private byte[] messagePayload;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTs;
}
