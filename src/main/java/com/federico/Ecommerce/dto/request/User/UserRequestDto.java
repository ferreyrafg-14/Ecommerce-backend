package com.federico.Ecommerce.dto.request.User;
import com.federico.Ecommerce.enums.Rol;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "El nombre es obligatorio")
    private String firstname;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8 ,  max = 16 , message = "La contraseña debe tener al menos 8 caracteres")
    private String password;


    private Rol role;

   @NotNull
    private Integer dni;

   @NotNull
   @Positive
    private Integer age;
}
