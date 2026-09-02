package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.Cart.CartRequestDto;
import com.federico.Ecommerce.dto.response.Cart.CartResponseDto;
import com.federico.Ecommerce.models.Entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "user", source = "userId" , ignore = true )
    Cart toEntity (CartRequestDto dto);

    @Mapping(target = "userId" , source = "user.userId")
    CartResponseDto toDto (Cart entity);
}
