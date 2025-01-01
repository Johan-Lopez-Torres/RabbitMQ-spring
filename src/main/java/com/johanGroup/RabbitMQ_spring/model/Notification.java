package com.johanGroup.RabbitMQ_spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();

}
