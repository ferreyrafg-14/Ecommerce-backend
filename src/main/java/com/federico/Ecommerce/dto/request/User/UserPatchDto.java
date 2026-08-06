package com.federico.Ecommerce.dto.request.User;
import lombok.Getter;
import lombok.Setter;
import com.federico.Ecommerce.enums.Rol;

@Setter
@Getter
public class UserPatchDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Rol role;
}
