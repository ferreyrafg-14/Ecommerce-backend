package com.federico.Ecommerce.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id_pedido;

    @Column(name = "estadopedido", nullable = false)
    private boolean estadopedido;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "fechacreacion", nullable = false)
    private LocalDateTime fechacreacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;

    // Constructor vacío
    public Pedido() {}

    // Constructor con parámetros
    public Pedido(Integer id_pedido, boolean estadopedido, BigDecimal total,
                  LocalDateTime fechacreacion, Usuario usuario) {
        this.id_pedido = id_pedido;
        this.estadopedido = estadopedido;
        this.total = total;
        this.fechacreacion = fechacreacion;
        this.usuario = usuario;
    }

    // Getters
    public Integer getId_pedido() {
        return id_pedido;
    }

    public boolean isEstadopedido() {
        return estadopedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // Setters
    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public void setEstadopedido(boolean estadopedido) {
        this.estadopedido = estadopedido;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setFechacreacion(LocalDateTime fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // toString
    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", estadopedido=" + estadopedido +
                ", total=" + total +
                ", fechacreacion=" + fechacreacion +
                ", usuario=" + usuario +
                '}';
    }
}