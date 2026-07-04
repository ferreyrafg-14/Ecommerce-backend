package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.models.Entity.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return service.crear(usuario);
    }
}
