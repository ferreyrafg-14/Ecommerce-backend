package com.federico.Ecommerce.dto.request.CartItem;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CartItemRequestDto(
        @NotNull @Positive Integer quantity,
        @NotNull Integer productId
) {

}
