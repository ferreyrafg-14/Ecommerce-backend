package com.federico.Ecommerce.models.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer orderId;

    @Column(name = "estadopedido", nullable = false)
    private String orderStatus;

    @Column(name = "total", nullable = true)
    private BigDecimal total;

    @CreationTimestamp
    @Column(name = "fechacreacion", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<Payment> payments = new ArrayList<>();

    public List<Payment> getPayments() {
        return payments;
    }

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

    public List<OrderItem> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderItem> orderDetails) {
        this.orderDetails = orderDetails;
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