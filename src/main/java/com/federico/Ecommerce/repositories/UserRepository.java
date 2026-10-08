package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);


}
