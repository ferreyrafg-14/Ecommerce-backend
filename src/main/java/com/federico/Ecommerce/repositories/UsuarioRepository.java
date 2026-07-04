package com.federico.Ecommerce.repositories;

import com.federico.Ecommerce.models.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
