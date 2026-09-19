package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.Order.OrderRequestDto;
import com.federico.Ecommerce.dto.response.Order.OrderResponseDto;
import com.federico.Ecommerce.models.Entity.Order;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "user" ,  source = "userId" , ignore = true)
    Order toEntity(OrderRequestDto dto);

    @Mapping(target = "userId", source = "user.userId")
    OrderResponseDto toDto(Order entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateOrderFromDto(OrderRequestDto dto, @MappingTarget Order entity);
}