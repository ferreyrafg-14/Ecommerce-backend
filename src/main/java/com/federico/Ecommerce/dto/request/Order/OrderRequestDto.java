package com.federico.Ecommerce.dto.request.Order;

import com.federico.Ecommerce.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
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


    @NotBlank
    private Integer userId;

    @NotBlank
    private Integer cartId;

    @NotBlank
    private Integer productId;


}
