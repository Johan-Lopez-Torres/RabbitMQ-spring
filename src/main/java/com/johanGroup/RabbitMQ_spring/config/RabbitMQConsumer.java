package com.johanGroup.RabbitMQ_spring.config;

import com.johanGroup.RabbitMQ_spring.model.Inventory;
import com.johanGroup.RabbitMQ_spring.model.Notification;
import com.johanGroup.RabbitMQ_spring.model.Order;
import com.johanGroup.RabbitMQ_spring.repository.InventoryRepository;
import com.johanGroup.RabbitMQ_spring.repository.NotificationRepository;
import com.johanGroup.RabbitMQ_spring.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RabbitMQConsumer {

    private final OrderRepository orderRepository;
    private final InventoryRepository inventoryRepository;
    private final NotificationRepository notificationRepository;

    public RabbitMQConsumer(OrderRepository orderRepository,
                            InventoryRepository inventoryRepository,
                            NotificationRepository notificationRepository) {
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    @RabbitListener(queues = RabbitMQConfig.ORDER_QUEUE)
    public void handleOrder(String message) {
        Order order = new Order();
        order.setOrderDetails(message);
        order.setStatus("PROCESSED");
        orderRepository.save(order);
        System.out.println("Pedido procesado: " + message);
    }

    @Transactional
    @RabbitListener(queues = RabbitMQConfig.INVENTORY_QUEUE)
    public void handleInventory(String message) {
        Integer productId = Integer.valueOf(message.split(":")[0]);
        Integer quantity = Integer.valueOf(message.split(":")[1]);

        Inventory inventory = inventoryRepository.findByProductId(productId);
        if (inventory != null) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            inventoryRepository.save(inventory);
            System.out.println("Inventario actualizado: " + message);
        }
    }

    @Transactional
    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void handleNotification(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setStatus("SENT");
        notificationRepository.save(notification);
        System.out.println("Notificación enviada: " + message);
    }
}
