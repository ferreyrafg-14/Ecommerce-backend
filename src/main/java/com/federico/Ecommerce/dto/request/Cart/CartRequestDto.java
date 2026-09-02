package com.federico.Ecommerce.dto.request.Cart;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {

    @NotNull
    private Integer userId;

}
