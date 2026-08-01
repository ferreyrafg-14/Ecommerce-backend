package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.UsuarioRequestDto;
import com.federico.Ecommerce.dto.response.UsuarioResponseDto;
import com.federico.Ecommerce.mapper.UsuarioMapper;
import com.federico.Ecommerce.models.Entity.Usuario;
import com.federico.Ecommerce.repositories.UsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper usuariomapper;
     public UsuarioService(UsuarioRepository repository ,  UsuarioMapper usuariomapper){
         this.repository = repository;
         this.usuariomapper = usuariomapper;

     }

     public UsuarioResponseDto crearUsuario(UsuarioRequestDto dto){
         Usuario usuarioEntity = usuariomapper.toEntity(dto);

         Usuario usuarioGuardado = repository.save(usuarioEntity);

         return usuariomapper.toResponseDto(usuarioGuardado);
     }

}
