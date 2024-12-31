package com.johanGroup.RabbitMQ_spring;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage() {
        rabbitTemplate.convertAndSend("testQueue", "Hello RabbitMQ");
    }
}
