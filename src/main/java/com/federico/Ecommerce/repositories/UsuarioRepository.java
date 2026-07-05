package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
