package com.federico.Ecommerce.models.embeddable;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemId implements Serializable {

    private Integer id_pedido;
    private Integer id_producto;

    public OrderItemId() {
    }

    public OrderItemId(Integer id_pedido, Integer id_producto) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
    }

    public Integer getId_orden() {
        return id_pedido;
    }

    public void setId_orden(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(id_pedido, that.id_pedido) &&
                Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pedido, id_producto);
    }
}