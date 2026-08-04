package com.federico.Ecommerce.controllers;


import com.federico.Ecommerce.dto.request.UsuarioRequestDto;
import com.federico.Ecommerce.dto.response.UsuarioResponseDto;
import com.federico.Ecommerce.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> CrearUsuario(@Valid @RequestBody UsuarioRequestDto dto ){
        UsuarioResponseDto response = service.crearUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> findAll(){
        List<UsuarioResponseDto> response = service.ObtenerUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> findById(@PathVariable Integer id){
        UsuarioResponseDto response = service.obtenerUsuarioId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /*@DeleteMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> EliminarUsuario(@PathVariable Integer id){
        UsuarioResponseDto response = service.eliminarUsuarioId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }*/

}


