package com.federico.Ecommerce.dto.request.Order;

import com.federico.Ecommerce.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDto {



    private OrderStatus status;


    private BigDecimal total;


    @NotNull
    private Integer userId;

    @NotNull
    private Integer cartId;

    @NotNull
    private Integer productId;


}
