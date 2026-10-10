package com.federico.Ecommerce.services;

import com.federico.Ecommerce.mapper.CartMapper;
import com.federico.Ecommerce.models.Entity.Cart;
import com.federico.Ecommerce.models.Entity.User;
import com.federico.Ecommerce.repositories.CartRepository;
import com.federico.Ecommerce.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartRepository repository;
    private final UserRepository userRepository;
    private final CartMapper mapper;
    private final CartItemService cartItemService;

    public CartService(CartRepository repository, CartMapper mapper ,  UserRepository userRepository ,  CartItemService cartItemService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.cartItemService = cartItemService;
    }
    //POST
    @Transactional
    public void createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        //cart.setCartId(user.getUserId());
        repository.save(cart);

    }
}
