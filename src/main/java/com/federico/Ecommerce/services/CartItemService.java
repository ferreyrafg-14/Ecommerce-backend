package com.federico.Ecommerce.services;


import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.models.Entity.Cart;
import com.federico.Ecommerce.models.Entity.CartItem;
import com.federico.Ecommerce.models.Entity.Product;
import com.federico.Ecommerce.models.embeddable.CartItemId;
import com.federico.Ecommerce.repositories.CartItemRepository;
import com.federico.Ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    public CartItemService(CartItemRepository cartItemRepository ,  ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;

    }

    public void createCartItem(Cart cart  , Integer quantity , Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        if(quantity > product.getStock()){
            throw new ResourceNotFoundException("Stock insuficiente");
        }
        CartItem cartItem = new CartItem();
        //GUARDANDO PK Y FK EN CARTITEM MODEL
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setCartItemId(new CartItemId());
        cartItem.setQuantity(quantity);
        product.setStock(product.getStock() - quantity);
        cartItemRepository.save(cartItem);
    }



}
