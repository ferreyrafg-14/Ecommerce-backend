package com.federico.Ecommerce.dto.request.Cart;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddCartRequestDto(
        @NotNull Integer userId,
        @NotNull @Positive Integer quantity,
        @NotNull Integer productId
) {}