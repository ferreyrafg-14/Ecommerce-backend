package com.federico.Ecommerce.dto.response.User;
import com.federico.Ecommerce.enums.Rol;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class UserResponseDto {

    private Integer userId;

    private String firstname;

    private String lastname;

    private String email;

    private Rol role;

    private LocalDateTime createdAt;

}
