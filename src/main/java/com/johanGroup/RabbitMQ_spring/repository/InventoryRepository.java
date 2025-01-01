package com.johanGroup.RabbitMQ_spring.repository;

import com.johanGroup.RabbitMQ_spring.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByProductId(Integer productId);
}
