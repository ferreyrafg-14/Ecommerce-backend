package com.federico.Ecommerce.models.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer id_carrito;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Carrito() {
    }

    public Carrito(Integer id_carrito, Usuario usuario) {
        this.id_carrito = id_carrito;
        this.usuario = usuario;
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id_carrito=" + id_carrito +
                ", usuario=" + usuario +
                '}';
    }
}