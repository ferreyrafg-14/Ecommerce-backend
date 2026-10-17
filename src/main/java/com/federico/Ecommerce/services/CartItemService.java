package com.federico.Ecommerce.services;


import com.federico.Ecommerce.dto.request.CartItem.CartItemRequestDto;
import com.federico.Ecommerce.dto.response.CartItem.CartItemResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.CartItemMapper;
import com.federico.Ecommerce.models.Entity.Cart;
import com.federico.Ecommerce.models.Entity.CartItem;
import com.federico.Ecommerce.models.Entity.Product;
import com.federico.Ecommerce.models.embeddable.CartItemId;
import com.federico.Ecommerce.repositories.CartItemRepository;
import com.federico.Ecommerce.repositories.CartRepository;
import com.federico.Ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemMapper cartItemMapper;
    public CartItemService(CartItemRepository cartItemRepository ,  ProductRepository productRepository ,  CartRepository cartRepository , CartItemMapper cartItemMapper) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartItemMapper = cartItemMapper;

    }

    public CartItemResponseDto createCartItem(CartItemRequestDto dto) {
        Product product = productRepository.findById(dto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        Cart cart = cartRepository.findById(dto.getCartId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado"));

        if(dto.getQuantity() > product.getStock()){
            throw new ResourceNotFoundException("Stock insuficiente");
        }
        CartItem cartItem = new CartItem();
        //GUARDANDO PK Y FK EN CARTITEM MODEL
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setCartItemId(new CartItemId());
        cartItem.setQuantity(dto.getQuantity());
        product.setStock(product.getStock() - dto.getQuantity());
        cartItemRepository.save(cartItem);
        return cartItemMapper.toDto(cartItem);
    }



}
