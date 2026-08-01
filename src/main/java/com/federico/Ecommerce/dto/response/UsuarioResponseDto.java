package com.federico.Ecommerce.dto.response;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UsuarioResponseDto {

    private Integer idUsuario;

    private String nombre;

    private String apellido;

    private String email;

    private String rol;

    private LocalDateTime fechaCreacion;

}
