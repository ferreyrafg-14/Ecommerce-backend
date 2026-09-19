package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
