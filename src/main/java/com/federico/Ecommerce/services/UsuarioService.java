package com.federico.Ecommerce.services;

import com.federico.Ecommerce.models.Entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
     public UsuarioService(UsuarioRepository repository){
            this.repository = repository;
     }

     public Usuario  crearUsuario(Usuario usuario){
         return repository.save(usuario);
     }

}
