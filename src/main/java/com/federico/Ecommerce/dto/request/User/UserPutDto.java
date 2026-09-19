package com.federico.Ecommerce.dto.request.User;

import com.federico.Ecommerce.enums.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPutDto {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Rol role;
}