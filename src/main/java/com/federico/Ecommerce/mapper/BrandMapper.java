package com.federico.Ecommerce.mapper;

import com.federico.Ecommerce.dto.request.brand.BrandRequestDto;
import com.federico.Ecommerce.dto.response.brand.BrandResponseDto;
import com.federico.Ecommerce.models.Entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toEntity(BrandRequestDto dto);

    BrandResponseDto toDto(Brand brand);
}
