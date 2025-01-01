package com.johanGroup.RabbitMQ_spring.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String ORDER_QUEUE = "order_queue";
    public static final String INVENTORY_QUEUE = "inventory_queue";
    public static final String NOTIFICATION_QUEUE = "notification_queue";
    public static final String EXCHANGE = "ecommerce_exchange";

    //EXCHANGES VARS FOR EXAMPLES
    public static final String FANOUT_EXCHANGE = "fanout-exchange";
    public static final String DIRECT_EXCHANGE = "direct-exchange";

    public static final String QUEUE_ONE = "queue_one";
    public static final String QUEUE_TWO = "queue_two";
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }


    //EXCHANGES EXAMPLES
    @Bean
    public FanoutExchange  fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }


    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE, true);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_TWO, true);
    }

    @Bean(name = "bindingFanoutOne")
    public Binding bindingFanoutOne(Queue queueOne, FanoutExchange exchange){
        return BindingBuilder.bind(queueOne).to(exchange);
    }

    @Bean(name = "bindingFanoutTwo")
    public Binding bindingFanoutTwo(Queue queueTwo, FanoutExchange exchange){
        return BindingBuilder.bind(queueTwo).to(exchange);
    }

    @Bean(name = "bindingDirectOne")
    public Binding bindingDirectOne(Queue queueOne, DirectExchange directExchange) {
        return BindingBuilder.bind(queueOne).to(directExchange).with("routingKeyOne");
    }

    @Bean(name = "bindingDirectTwo")
    public Binding bindingDirectTwo(Queue queueTwo, DirectExchange directExchange) {
        return BindingBuilder.bind(queueTwo).to(directExchange).with("routingKeyTwo");
    }


    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE);
    }






    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE, true);
    }

    @Bean
    public Queue inventoryQueue() {
        return new Queue(INVENTORY_QUEUE, true);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(NOTIFICATION_QUEUE, true);
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, TopicExchange exchange) {
        return BindingBuilder.bind(orderQueue).to(exchange).with("order.#");
    }

    @Bean
    public Binding inventoryBinding(Queue inventoryQueue, TopicExchange exchange) {
        return BindingBuilder.bind(inventoryQueue).to(exchange).with("inventory.#");
    }

    @Bean
    public Binding notificationBinding(Queue notificationQueue, TopicExchange exchange) {
        return BindingBuilder.bind(notificationQueue).to(exchange).with("notification.#");
    }
}
