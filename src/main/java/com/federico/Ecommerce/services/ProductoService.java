package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.repositories.UserRepository;

public class ProductoService {
    private final UserRepository userRepository;

    public ProductoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*POST
    public ProductResponseDto createProduct(ProductRequestDto ProductRequestDto) {

    }*/
}
