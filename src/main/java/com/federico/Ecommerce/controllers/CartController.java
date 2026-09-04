package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.Cart.CartRequestDto;
import com.federico.Ecommerce.dto.response.Cart.CartResponseDto;

import com.federico.Ecommerce.services.CartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Cart")
public class CartController {
    private final CartService service;


    public CartController(CartService service) {
        this.service = service;
    }


    @PostMapping("/{productId}")
    public ResponseEntity<CartResponseDto> createCart(@Valid @RequestBody CartRequestDto dto , @PathVariable Integer productId){
        CartResponseDto response = service.createCart(dto , productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
