package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.Order.OrderRequestDto;
import com.federico.Ecommerce.dto.response.Order.OrderResponseDto;
import com.federico.Ecommerce.models.Entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderStatus" , ignore = true)
    @Mapping(target = "total" , ignore = true)
    Order toEntity(OrderRequestDto dto);

    OrderResponseDto toResponseDto(Order order);
}
