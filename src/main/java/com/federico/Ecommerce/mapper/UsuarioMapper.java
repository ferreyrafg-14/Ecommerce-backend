package com.federico.Ecommerce.mapper;
import com.federico.Ecommerce.dto.request.UsuarioRequestDto;

import com.federico.Ecommerce.dto.response.UsuarioResponseDto;
import com.federico.Ecommerce.models.Entity.Usuario;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioRequestDto dto);

    UsuarioResponseDto toResponseDto(Usuario entity);
}
