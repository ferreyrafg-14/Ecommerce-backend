package com.federico.Ecommerce.services;

import com.federico.Ecommerce.dto.request.Cart.CartRequestDto;
import com.federico.Ecommerce.dto.response.Cart.CartResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.CartMapper;
import com.federico.Ecommerce.models.Entity.Cart;
import com.federico.Ecommerce.models.Entity.User;
import com.federico.Ecommerce.repositories.CartRepository;
import com.federico.Ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository repository;
    private final UserRepository userRepository;
    private final CartMapper mapper;

    public CartService(CartRepository repository, CartMapper mapper ,  UserRepository userRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }
    //POST
    public CartResponseDto CreateCart(CartRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Cart cart = mapper.toEntity(dto);
        cart.setUser(user);
        Cart  savedCart = repository.save(cart);
        return mapper.toDto(savedCart);
    }
}
