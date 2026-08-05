package com.federico.Ecommerce.dto.request;
import lombok.Getter;
import lombok.Setter;
import com.federico.Ecommerce.enums.Rol;

@Setter
@Getter
public class UsuarioPatchDto {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Rol rol;
}
