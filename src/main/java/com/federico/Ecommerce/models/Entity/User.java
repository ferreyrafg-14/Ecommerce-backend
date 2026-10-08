package com.federico.Ecommerce.models.Entity;

import com.federico.Ecommerce.enums.Rol;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer userId;

    @Column(name = "nombre", nullable = false)
    private String firstname;

    @Column(name = "apellido", nullable = false)
    private String lastname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "rol", nullable = false)
    @Enumerated(EnumType.STRING)
    private Rol role;

    @Column(name = "dni" , nullable = false)
    private Integer dni;

    @Column(name = "fecha_nacimiento")
    private LocalDate birth_date;

    @CreationTimestamp
    @Column(name = "fechacreacion", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Integer userId, String firstname, String lastname,
                String email, String password, Rol role,
                LocalDateTime createdAt , Integer dni  , LocalDate birth_date) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.dni = dni;
        this.birth_date = birth_date;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



    @Override
    public String  toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", dni=" + dni +
                ", createdAt=" + createdAt +
                ", orders=" + orders +
                '}';
    }
}