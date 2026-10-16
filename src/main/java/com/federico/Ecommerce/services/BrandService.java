package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.brand.BrandRequestDto;
import com.federico.Ecommerce.dto.response.brand.BrandResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.BrandMapper;
import com.federico.Ecommerce.models.Entity.Brand;
import com.federico.Ecommerce.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public  BrandService(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }
    public BrandResponseDto addBrand(BrandRequestDto dto){
        Brand brand = brandMapper.toEntity(dto);
        brandRepository.save(brand);
        return brandMapper.toDto(brand);
    }

    public BrandResponseDto getBrandById(Integer id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada"));
        return brandMapper.toDto(brand);
    }

    public List<BrandResponseDto> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandResponseDto> response = new ArrayList<>();

        for (Brand brand : brands) {
            response.add(brandMapper.toDto(brand));
        }

        return response;
    }

    public BrandResponseDto updateBrand(Integer id, BrandRequestDto dto) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada"));
        brandMapper.toEntity(dto);
        brandRepository.save(brand);
        return brandMapper.toDto(brand);
    }

    public BrandResponseDto deleteBrandById(Integer id) {

        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada"));

        BrandResponseDto responseDto = brandMapper.toDto(brand);

        brandRepository.deleteById(id);

        return responseDto;
    }

}
