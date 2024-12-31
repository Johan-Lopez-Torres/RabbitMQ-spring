package com.johanGroup.RabbitMQ_spring;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSpringApplication.class, args);
	}

	@PostConstruct
	public void checkRabbitConnection() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("35.225.25.142");
			factory.setPort(5672);
			factory.setUsername("guest");
			factory.setPassword("guest");
			try (Connection connection = factory.newConnection()) {
				System.out.println("Connected to RabbitMQ successfully!");
			}
		} catch (Exception e) {
			System.out.println("Failed to connect to RabbitMQ: " + e.getMessage());
		}
	}


}
