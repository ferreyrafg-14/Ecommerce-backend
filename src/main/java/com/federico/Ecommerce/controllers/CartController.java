package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.services.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Cart")
public class CartController {
    private final CartService service;


    public CartController(CartService service) {
        this.service = service;
    }

}
