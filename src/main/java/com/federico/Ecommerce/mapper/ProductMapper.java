package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.models.Entity.Product;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category" ,  source = "categoryId" , ignore = true)
    Product toEntity(ProductRequestDto dto);

    @Mapping(target = "categoryId", source = "category.categoryId")
    ProductResponseDto toDto(Product entity);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateProductFromDto(ProductRequestDto dto, @MappingTarget Product entity);
}