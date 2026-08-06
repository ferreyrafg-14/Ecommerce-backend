package com.federico.Ecommerce.models.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer orderId;

    @Column(name = "estadopedido", nullable = false)
    private String orderStatus;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "fechacreacion", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;

    // Constructor vacío
    public Order() {}

    // Constructor con parámetros
    public Order(Integer orderId, String orderStatus, BigDecimal total,
                 LocalDateTime createdAt, User user) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.total = total;
        this.createdAt = createdAt;
        this.user = user;
    }

    // Getters
    public Integer getOrderId() {
        return orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // toString
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus='" + orderStatus + '\'' +
                ", total=" + total +
                ", createdAt=" + createdAt +
                ", user=" + user +
                '}';
    }
}