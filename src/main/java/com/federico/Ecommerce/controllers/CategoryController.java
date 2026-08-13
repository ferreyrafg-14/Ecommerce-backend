package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.Category.CategoryPatchDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPostDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPutDto;
import com.federico.Ecommerce.dto.response.Category.CategoryResponseDto;
import com.federico.Ecommerce.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> replaceCategory(@PathVariable Integer id,@RequestBody CategoryPutDto dto){
        CategoryResponseDto response = service.replaceCategory(id , dto);
        return  ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        List<CategoryResponseDto> response = service.getAllCategories();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Integer id){
        CategoryResponseDto response = service.getCategoryById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable Integer id){

        CategoryResponseDto response =  service.deleteCategory(id);
        return ResponseEntity.ok(response);
    }
}
