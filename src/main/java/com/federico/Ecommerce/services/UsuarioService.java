package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.UsuarioRequestDto;
import com.federico.Ecommerce.dto.response.UsuarioResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.UsuarioMapper;
import com.federico.Ecommerce.models.Entity.Usuario;
import com.federico.Ecommerce.repositories.UsuarioRepository;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




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

     public UsuarioResponseDto obtenerUsuarioId(Integer id){
         Usuario usuarioObtenido = repository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado ")) ;
         return usuariomapper.toResponseDto(usuarioObtenido);
     }

     public List<UsuarioResponseDto> ObtenerUsuarios(){
            List<Usuario> listaUsuarios = repository.findAll();

            if(listaUsuarios.isEmpty()){
                throw new ResourceNotFoundException("Usuarios no encontrados");
            }

            List<UsuarioResponseDto> listaResponseDto = new ArrayList<>();

            for(Usuario usuario : listaUsuarios){
                listaResponseDto.add(usuariomapper.toResponseDto(usuario));
            }

            return  listaResponseDto;

     }

     /*public void  EliminarUsuarioId(Integer id){
         if(!repository.existsById(id)){
             throw new ResourceNotFoundException("Usuario no encontrado");
         }
         repository.deleteById(id);

     }*/

    public UsuarioResponseDto EliminarUsuarioId(Integer id){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        UsuarioResponseDto dto = usuariomapper.toResponseDto(usuario);

        repository.deleteById(id);

        return dto;

    }


}
