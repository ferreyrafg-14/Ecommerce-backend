package com.federico.Ecommerce.services;

import com.federico.Ecommerce.exception.ResourceNotFoundException;
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
    private final ProductRepository productRepository;;
    private final CartRepository cartRepository;

    public CartItemService(CartItemRepository cartItemRepository ,  ProductRepository productRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;

    }

    public void createCartItem(Integer cartId , Integer Quantity , Integer productId) {
        CartItem cartItem = new CartItem();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart no encontrado"));

        //GUARDANDO PK Y FK EN CARTITEM MODEL
        cartItem.setCart(cart);
        cartItem.setCartItemId(new CartItemId());
        cartItem.setProduct(product);
        cartItem.setQuantity(Quantity);
        product.setStock(product.getStock() - Quantity);
        CartItem savedCartItem = cartItemRepository.save(cartItem);

    }



}
