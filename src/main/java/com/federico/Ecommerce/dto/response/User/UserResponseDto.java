package com.federico.Ecommerce.dto.response.User;
import com.federico.Ecommerce.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponseDto {

    private Integer userId;

    private String firstname;

    private String lastname;

    private String email;

    private Integer dni;

    private Rol role;

    private Integer age;

    private LocalDate birth_date;

    private LocalDateTime createdAt;

}
