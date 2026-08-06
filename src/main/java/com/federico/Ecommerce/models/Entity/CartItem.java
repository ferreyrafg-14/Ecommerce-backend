package com.federico.Ecommerce.models.Entity;

import com.federico.Ecommerce.models.embeddable.CartItemId;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_carrito")
public class CartItem {

    @EmbeddedId
    private CartItemId cartItemId;

    @ManyToOne
    @MapsId("id_carrito")
    @JoinColumn(name = "id_carrito", nullable = false)
    private Cart cart;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;

    @Column(name = "cantidad", nullable = false)
    private Integer quantity;

    public CartItem() {
    }

    public CartItem(CartItemId cartItemId,
                    Cart cart,
                    Product product,
                    Integer quantity) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItemId getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(CartItemId cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", quantity=" + quantity +
                '}';
    }
}