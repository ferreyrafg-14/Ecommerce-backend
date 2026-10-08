package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.CartItem;
import com.federico.Ecommerce.models.embeddable.CartItemId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
}
