package com.federico.Ecommerce.models;
import jakarta.persistence.*;
@Entity
@Table(name = "carrito")
public class Carrito{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer id_carrito;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Integer id_usuario;

    public Carrito() {
    }

    public Carrito(Integer id_carrito, Integer id_usuario) {
        this.id_carrito = id_carrito;
        this.id_usuario = id_usuario;
    }

    public Integer getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Integer id_carrito) {
        this.id_carrito = id_carrito;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id_carrito=" + id_carrito +
                ", id_usuario=" + id_usuario +
                '}';
    }
}
