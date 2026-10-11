package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.response.Cart.CartResponseDto;
import com.federico.Ecommerce.services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService service;


    public CartController(CartService service) {
        this.service = service;
    }

    //GET
    @GetMapping
    public ResponseEntity<List<CartResponseDto>> getAllCarts(){
        List<CartResponseDto> response = service.getAllCarts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponseDto> getCartById(@PathVariable int id){
        CartResponseDto response = service.getCartById(id);
        return ResponseEntity.ok(response);
    }

}
