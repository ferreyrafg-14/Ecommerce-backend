package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.request.User.UserRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.dto.response.User.UserResponseDto;
import com.federico.Ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductController {
    private UserService userService;

    public ProductController(UserService userService) {
        this.userService = userService;
    }

    /*POST
    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@Valid @RequestBody ProductRequestDto ProductRequestDto){
        ProductResponseDto productResponseDto = userService.createProduct(ProductRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    }*/
}
