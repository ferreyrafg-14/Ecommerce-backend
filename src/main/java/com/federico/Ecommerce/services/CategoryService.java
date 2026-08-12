package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.Category.CategoryPatchDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPostDto;
import com.federico.Ecommerce.dto.response.Category.CategoryResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.CategoryMapper;
import com.federico.Ecommerce.models.Entity.Category;
import com.federico.Ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository  repository;
    private final CategoryMapper mapper;
    public CategoryService(CategoryRepository repository , CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //POST
    public CategoryResponseDto  createCategory(CategoryPostDto dto){
        Category categoryEntity = mapper.toEntity(dto);
        Category savedCategory = repository.save(categoryEntity);
        return mapper.toResponseDto(savedCategory);
    }

    //PATCH
    public CategoryResponseDto UpdateCategory(CategoryPatchDto dto , Integer id){
        Category categoryId = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
         mapper.updateCategoryFromDto(dto , categoryId);

         Category savedCategory = repository.save(categoryId);

         return mapper.toResponseDto(savedCategory);
    }
}
