package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.UsuarioPatchDto;
import com.federico.Ecommerce.dto.request.UsuarioPutDto;
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
    //POSTMAPPING
     public UsuarioResponseDto crearUsuario(UsuarioRequestDto dto){
         Usuario usuarioEntity = usuariomapper.toEntity(dto);

         Usuario usuarioGuardado = repository.save(usuarioEntity);

         return usuariomapper.toResponseDto(usuarioGuardado);
     }

     //PUTMAPPING
     public UsuarioResponseDto updateAll(Integer id , UsuarioPutDto dto) {
         Usuario usuario = repository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

         usuariomapper.updateUsuarioFromDtoAll(dto ,usuario);
         Usuario datos = repository.save(usuario);
         return usuariomapper.toResponseDto(datos);
     }

     //PATCHMAPPING
    public UsuarioResponseDto update(Integer id , UsuarioPatchDto dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        usuariomapper.updateUsuarioFromDto(dto ,usuario);
         Usuario datos = repository.save(usuario);
        return usuariomapper.toResponseDto(datos);
    }

     //GETMAPPING
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
    //DELETE MAPPING
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
