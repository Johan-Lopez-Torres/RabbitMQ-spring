package com.johanGroup.RabbitMQ_spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "jsonb")
    private String orderDetails;

    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();

}
