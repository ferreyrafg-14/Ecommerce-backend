package com.federico.Ecommerce.models.embeddable;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetalleCarritoId implements Serializable {
    private Integer id_carrito;
    private Integer id_producto;

    public DetalleCarritoId() {
    }

    public DetalleCarritoId(Integer id_carrito, Integer id_producto) {
        this.id_carrito = id_carrito;
        this.id_producto = id_producto;
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
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
        DetalleCarritoId that = (DetalleCarritoId) o;
        return Objects.equals(id_carrito, that.id_carrito) && Objects.equals(id_producto, that.id_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_carrito, id_producto);
    }
}
