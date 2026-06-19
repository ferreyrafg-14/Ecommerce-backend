package com.federico.Ecommerce.models.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id_pago;

    @Column(name = "metodo", nullable = false)
    private String metodo;

    @Column(name = "estadopago", nullable = false)
    private boolean estadopago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDateTime fecha_pago;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public Pago() {
    }

    public Pago(Integer id_pago, String metodo, boolean estadopago,
                LocalDateTime fecha_pago, Pedido pedido) {
        this.id_pago = id_pago;
        this.metodo = metodo;
        this.estadopago = estadopago;
        this.fecha_pago = fecha_pago;
        this.pedido = pedido;
    }

    public Integer getId_pago() {
        return id_pago;
    }

    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public boolean isEstadopago() {
        return estadopago;
    }

    public void setEstadopago(boolean estadopago) {
        this.estadopago = estadopago;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id_pago=" + id_pago +
                ", metodo='" + metodo + '\'' +
                ", estadopago=" + estadopago +
                ", fecha_pago=" + fecha_pago +
                ", pedido=" + pedido +
                '}';
    }
}