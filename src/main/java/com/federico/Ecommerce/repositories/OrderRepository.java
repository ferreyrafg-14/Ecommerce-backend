package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Integer> {
}
