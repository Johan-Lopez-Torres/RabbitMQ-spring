package com.johanGroup.RabbitMQ_spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer productId;
    private Integer quantity;
    private LocalDateTime updatedAt = LocalDateTime.now();

}
