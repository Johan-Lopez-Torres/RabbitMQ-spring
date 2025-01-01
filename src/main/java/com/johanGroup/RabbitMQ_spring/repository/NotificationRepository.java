package com.johanGroup.RabbitMQ_spring.repository;

import com.johanGroup.RabbitMQ_spring.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

