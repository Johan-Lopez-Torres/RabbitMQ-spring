package com.johanGroup.RabbitMQ_spring.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void handleOrderQueue(String message) {
        System.out.println("Procesando pedido: " + message);
        // Lógica para procesar pedidos
    }

    @RabbitListener(queues = RabbitMQConfig.INVENTORY_QUEUE)
    public void handleInventoryQueue(String message) {
        System.out.println("Actualizando inventario: " + message);
        // Lógica para actualizar inventario
    }

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void handleNotificationQueue(String message) {
        System.out.println("Enviando notificación: " + message);
        // Lógica para enviar notificaciones
    }
}
