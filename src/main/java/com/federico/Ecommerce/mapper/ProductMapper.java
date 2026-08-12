package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.Product.ProductPatchDto;
import com.federico.Ecommerce.dto.request.Product.ProductPutDto;
import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.models.Entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toEntity(ProductRequestDto dto);

    @Mapping(source = "category.categoryName", target = "categoryName")
    ProductResponseDto toResponseDto(Product entity);

    @Mapping(target = "category", ignore = true)
    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    void updateProductFromDto(
            ProductPatchDto dto,
            @MappingTarget Product product
    );

    @Mapping(target = "category", ignore = true)
    void updateProductFromDtoAll(
            ProductPutDto dto,
            @MappingTarget Product product
    );
}