package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.CartItem.CartItemRequestDto;
import com.federico.Ecommerce.dto.response.CartItem.CartItemResponseDto;
import com.federico.Ecommerce.models.Entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface CartItemMapper {
    @Mapping(target = "cart" , ignore = true)
    @Mapping(target = "product" , ignore = true)
    @Mapping(target = "quantity" , ignore = true)
    CartItem toEntity(CartItemRequestDto dto);

    @Mapping(target = "productId"  , source = "product.productId")
    @Mapping(target = "cartId" , source = "cart.cartId")
    CartItemResponseDto toDto(CartItem cartItem);
}
