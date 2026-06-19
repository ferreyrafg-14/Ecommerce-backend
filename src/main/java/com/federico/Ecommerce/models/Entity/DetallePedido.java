package com.federico.Ecommerce.models.Entity;

import com.federico.Ecommerce.models.embeddable.DetallePedidoId;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @EmbeddedId
    private DetallePedidoId detallePedidoId;

    @ManyToOne
    @MapsId("id_pedido")
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido id_pedido;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto id_producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "preciunitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal preciunitario;

    public DetallePedido() {
    }

    public DetallePedido(DetallePedidoId detallePedidoId, Integer cantidad, BigDecimal preciunitario) {
        this.detallePedidoId = detallePedidoId;
        this.cantidad = cantidad;
        this.preciunitario = preciunitario;
    }

    public DetallePedidoId getDetallePedidoId() {
        return detallePedidoId;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPreciunitario() {
        return preciunitario;
    }

    public void setPreciunitario(BigDecimal preciunitario) {
        this.preciunitario = preciunitario;
    }
}