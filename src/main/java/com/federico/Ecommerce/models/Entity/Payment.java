package com.federico.Ecommerce.models.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer paymentId;

    @Column(name = "metodo", nullable = false)
    private String method;

    @Column(name = "estadopago", nullable = false)
    private boolean paymentStatus;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Order order;

    public Payment() {
    }

    public Payment(Integer paymentId, String method, boolean paymentStatus,
                   LocalDateTime paymentDate, Order order) {
        this.paymentId = paymentId;
        this.method = method;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.order = order;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", method='" + method + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", paymentDate=" + paymentDate +
                ", order=" + order +
                '}';
    }
}