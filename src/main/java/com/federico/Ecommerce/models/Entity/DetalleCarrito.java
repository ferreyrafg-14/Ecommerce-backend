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
    @JoinColumn(name = "id_carrito" ,nullable = false , unique = true )
    private Integer id_carrito;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto" ,nullable = false , unique = true )
    private Integer id_producto;

    @Column(name = "cantidad" , nullable = false)
    private Integer cantidad;

    public DetalleCarrito() {
    }

    public DetalleCarrito(DetalleCarritoId detalleCarritoId , Integer cantidad) {
        this.detalleCarritoId = detalleCarritoId;
        this.cantidad = cantidad;
    }

    public DetalleCarritoId getDetalleCarritoId() {
        return detalleCarritoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
