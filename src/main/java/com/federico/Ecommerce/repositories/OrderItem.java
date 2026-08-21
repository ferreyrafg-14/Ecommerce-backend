package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.embeddable.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItem extends JpaRepository<OrderItem, OrderItemId> {
}
