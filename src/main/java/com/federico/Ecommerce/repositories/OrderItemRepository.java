package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.OrderItem;
import com.federico.Ecommerce.models.embeddable.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
