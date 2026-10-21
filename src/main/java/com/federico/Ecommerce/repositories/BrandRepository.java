package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
