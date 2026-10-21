package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.Category.CategoryPatchDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPostDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPutDto;
import com.federico.Ecommerce.dto.response.Category.CategoryResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.CategoryMapper;
import com.federico.Ecommerce.models.Entity.Category;
import com.federico.Ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    //PUT
    public CategoryResponseDto replaceCategory(Integer id, CategoryPutDto dto){
        Category categoryId = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        mapper.updateCategoryFromDtoAll(dto , categoryId);

        Category savedCategory = repository.save(categoryId);
        return mapper.toResponseDto(savedCategory);
    }

    //DELETE
    public CategoryResponseDto deleteCategory(Integer id){
        Category categoryId = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        CategoryResponseDto responseDto = mapper.toResponseDto(categoryId);
         repository.deleteById(id);

         return responseDto;
    }

    //GET
    public List<CategoryResponseDto> getAllCategories(){
        List<Category> categoryEntities = repository.findAll();

        if(categoryEntities.isEmpty()) throw new ResourceNotFoundException("Categorias no encontradas");

        List<CategoryResponseDto> responseDtos = new ArrayList<>();

        for(Category category : categoryEntities){
            responseDtos.add(mapper.toResponseDto(category));
        }

        return responseDtos;
    }

    public CategoryResponseDto getCategoryById(Integer id){
        Category categoryId =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        return mapper.toResponseDto(categoryId);


    }
}
