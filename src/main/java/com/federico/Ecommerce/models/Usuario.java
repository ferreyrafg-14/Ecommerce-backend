package com.federico.Ecommerce.models;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "nombre" , nullable = true  )
    private String nombre;

    @Column(name = "apellido" , nullable = true )
    private String apellido;

    @Column(name =  "email", nullable = true  , unique = true)
    private String email;

    @Column(name = "password" , nullable = true )
    private String password;

    @Column(name = "rol" , nullable = true )
    private String rol;

    @Column(name = "fechacreacion" , nullable = true )
    private LocalDateTime fechacreacion;



    public Usuario(){}

    public Usuario(Long id_usuario, String nombre, String apellido, String email, String password, String rol, LocalDateTime fechacreacion) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.fechacreacion = fechacreacion;
    }

    public Long getId() {
        return id_usuario;
    }

    public void setId(Long id) {
        this.id_usuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDateTime getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDateTime fechacreacion) {
        this.fechacreacion = fechacreacion;
    }


    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", fecha_creacion=" + fechacreacion +
                '}';
    }
}
