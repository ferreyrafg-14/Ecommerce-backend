package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
