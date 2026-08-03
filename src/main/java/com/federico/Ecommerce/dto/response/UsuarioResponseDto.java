package com.federico.Ecommerce.dto.response;
import com.federico.Ecommerce.enums.Rol;
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

    private Rol rol;

    private LocalDateTime fechaCreacion;

}
