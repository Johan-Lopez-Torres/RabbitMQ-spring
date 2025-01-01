package com.johanGroup.RabbitMQ_spring.repository;

import com.johanGroup.RabbitMQ_spring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
