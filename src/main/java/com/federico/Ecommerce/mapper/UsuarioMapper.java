package com.federico.Ecommerce.mapper;
import com.federico.Ecommerce.dto.request.UsuarioPatchDto;
import com.federico.Ecommerce.dto.request.UsuarioPutDto;
import com.federico.Ecommerce.dto.request.UsuarioRequestDto;

import com.federico.Ecommerce.dto.response.UsuarioResponseDto;
import com.federico.Ecommerce.models.Entity.Usuario;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity(UsuarioRequestDto dto);

    UsuarioResponseDto toResponseDto(Usuario entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateUsuarioFromDto(
            UsuarioPatchDto dto,
            @MappingTarget Usuario usuario
    );

    void updateUsuarioFromDtoAll(
            UsuarioPutDto dto,
            @MappingTarget Usuario usuario
    );


}