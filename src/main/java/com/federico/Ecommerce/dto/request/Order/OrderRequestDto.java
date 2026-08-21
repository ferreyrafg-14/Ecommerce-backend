package com.federico.Ecommerce.dto.request.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class OrderRequestDto {
        @NotBlank
        @NotNull
        private String orderStatus;

        @Positive
        private BigDecimal total;

        @NotNull
        private Integer userId;
}
