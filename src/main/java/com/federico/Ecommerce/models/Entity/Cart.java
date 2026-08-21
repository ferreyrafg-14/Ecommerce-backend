package com.federico.Ecommerce.models.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrito")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer cartId;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart() {
    }

    public Cart(Integer cartId, User user) {
        this.cartId = cartId;
        this.user = user;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                '}';
    }
}