package com.federico.Ecommerce.controllers;


import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
            this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto dto) {
        ProductResponseDto response = service.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto>  updateProduct(@Valid @PathVariable int id, @RequestBody ProductRequestDto dto) {
        ProductResponseDto response = service.updateProduct(id , dto);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> putProduct(@Valid @PathVariable int id, @RequestBody ProductRequestDto dto) {
        ProductResponseDto response = service.putProduct(id , dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAllProducts() {
        List<ProductResponseDto> response = service.findAllProducts();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findProductById(@PathVariable int id) {
        ProductResponseDto response = service.findProductById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable int id) {
        ProductResponseDto response = service.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

}
