package com.johanGroup.RabbitMQ_spring;

import com.johanGroup.RabbitMQ_spring.config.RabbitMQSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitMqSpringApplication implements  CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSpringApplication.class, args);
	}



	private final RabbitMQSender rabbitMQSender;

	@Override
	public void run(String... args) {
		System.out.println("Hello World from RabbitMQ Spring");

		rabbitMQSender.sendOrderMessage("order.created", "Nuevo pedido creado: ID 1234");


	}

}
