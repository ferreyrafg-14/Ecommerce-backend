package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
