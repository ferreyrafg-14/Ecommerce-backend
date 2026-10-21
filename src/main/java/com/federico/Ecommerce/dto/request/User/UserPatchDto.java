package com.federico.Ecommerce.dto.request.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.federico.Ecommerce.enums.Rol;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserPatchDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Rol role;
    private LocalDate birth_date;
}
