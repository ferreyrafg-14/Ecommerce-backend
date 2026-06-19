package com.federico.Ecommerce.models.embeddable;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetallePedidoId implements Serializable {

    private Integer id_pedido;
    private Integer id_producto;

    public DetallePedidoId() {
    }

    public DetallePedidoId(Integer id_pedido, Integer id_producto) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
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
        DetallePedidoId that = (DetallePedidoId) o;
        return Objects.equals(id_pedido, that.id_pedido) &&
                Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pedido, id_producto);
    }
}