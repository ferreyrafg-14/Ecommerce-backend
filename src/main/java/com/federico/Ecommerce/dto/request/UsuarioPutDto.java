package com.federico.Ecommerce.dto.request;

import com.federico.Ecommerce.enums.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPutDto {

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private Rol rol;
}