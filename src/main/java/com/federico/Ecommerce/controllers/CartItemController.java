package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.CartItem.CartItemRequestDto;
import com.federico.Ecommerce.dto.response.CartItem.CartItemResponseDto;
import com.federico.Ecommerce.services.CartItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/CartItems")
public class CartItemController {
    private final CartItemService cartItemService;
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping()
    public ResponseEntity<CartItemResponseDto> createCartItem(@Valid @RequestBody CartItemRequestDto dto){
        CartItemResponseDto response = cartItemService.createCartItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<CartItemResponseDto> updateCartItem(@PathVariable Integer id, @Valid @RequestBody CartItemRequestDto dto){
        CartItemResponseDto response = cartItemService.updateCartItem(dto);
        return ResponseEntity.ok(response);
    }
}
