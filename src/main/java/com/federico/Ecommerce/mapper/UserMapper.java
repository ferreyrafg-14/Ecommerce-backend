package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.User.UserPatchDto;
import com.federico.Ecommerce.dto.request.User.UserPutDto;
import com.federico.Ecommerce.dto.request.User.UserRequestDto;
import com.federico.Ecommerce.dto.response.User.UserResponseDto;
import com.federico.Ecommerce.models.Entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password" ,  ignore = true)
    User toEntity(UserRequestDto dto);

    UserResponseDto toResponseDto(User entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateUserFromDto(
            UserPatchDto dto,
            @MappingTarget User user
    );

    void updateUserFromDtoAll(
            UserPutDto dto,
            @MappingTarget User user
    );
}