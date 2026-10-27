package com.federico.Ecommerce.dto.request.CartItem;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequestDto {

    @NotNull
    private Integer cartId;

    @NotNull
    private Integer productId;

    @NotNull(message = "La cantidad debe ser positiva")
    @Positive
    private int quantity;
}
