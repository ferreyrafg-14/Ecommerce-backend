package com.federico.Ecommerce.models.Entity;

import com.federico.Ecommerce.models.embeddable.DetalleCarritoId;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_carrito")
public class DetalleCarrito {

    @EmbeddedId
    private DetalleCarritoId detalleCarritoId;

    @ManyToOne
    @MapsId("id_carrito")
    @JoinColumn(name = "id_carrito", nullable = false)
    private Carrito carrito;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public DetalleCarrito() {
    }

    public DetalleCarrito(DetalleCarritoId detalleCarritoId,
                          Carrito carrito,
                          Producto producto,
                          Integer cantidad) {
        this.detalleCarritoId = detalleCarritoId;
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public DetalleCarritoId getDetalleCarritoId() {
        return detalleCarritoId;
    }

    public void setDetalleCarritoId(DetalleCarritoId detalleCarritoId) {
        this.detalleCarritoId = detalleCarritoId;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleCarrito{" +
                "detalleCarritoId=" + detalleCarritoId +
                ", cantidad=" + cantidad +
                '}';
    }
}