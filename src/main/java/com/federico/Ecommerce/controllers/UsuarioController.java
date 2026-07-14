package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.models.Entity.Usuario;
import com.federico.Ecommerce.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return service.crearUsuario(usuario);
    }

}


