package com.johanGroup.RabbitMQ_spring.controller;

import com.johanGroup.RabbitMQ_spring.config.RabbitMQSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final RabbitMQSender rabbitMQSender;

    public OrderController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping
    public String createOrder(@RequestBody String orderDetails) {
        rabbitMQSender.sendOrderMessage("order.created", orderDetails);
        rabbitMQSender.sendOrderMessage("inventory.update", "Reducir stock para: " + orderDetails);
        rabbitMQSender.sendOrderMessage("notification.send", "Pedido recibido: " + orderDetails);
        return "Pedido recibido y en proceso.";
    }
}
