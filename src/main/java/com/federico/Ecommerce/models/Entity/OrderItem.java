package com.federico.Ecommerce.models.Entity;

import com.federico.Ecommerce.models.embeddable.OrderItemId;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class OrderItem {

    @EmbeddedId
    private OrderItemId orderItemId;

    @ManyToOne
    @MapsId("id_pedido")
    @JoinColumn(name = "id_pedido", nullable = false)
    private Order order;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto", nullable = false)
    private Product product;

    @Column(name = "cantidad", nullable = false)
    private Integer quantity;

    @Column(name = "preciounitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    public OrderItem() {
    }

    public OrderItem(OrderItemId orderItemId, Integer quantity, BigDecimal unitPrice) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderItemId getOrderItemId() {
        return orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}