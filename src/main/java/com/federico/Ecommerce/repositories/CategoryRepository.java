package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
