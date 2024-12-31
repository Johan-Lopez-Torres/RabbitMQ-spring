package com.johanGroup.RabbitMQ_spring;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue testQueue() {
        return new Queue("testQueue", true); // durable queue
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchangeName");
    }

    @Bean
    public Binding binding(Queue testQueue, DirectExchange exchange) {
        return BindingBuilder.bind(testQueue).to(exchange).with("routingKey");
    }
}
