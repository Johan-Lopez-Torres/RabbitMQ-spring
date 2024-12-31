package com.johanGroup.RabbitMQ_spring;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {
    @RabbitListener(queues = "testQueue")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }
}
