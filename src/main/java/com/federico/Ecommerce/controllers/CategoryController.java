package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.Category.CategoryPatchDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPostDto;
import com.federico.Ecommerce.dto.response.Category.CategoryResponseDto;
import com.federico.Ecommerce.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryPostDto dto){
        CategoryResponseDto response = service.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Integer id ,@RequestBody CategoryPatchDto dto){
       CategoryResponseDto response =  service.UpdateCategory(dto,id);

       return  ResponseEntity.ok(response);

    }
}
