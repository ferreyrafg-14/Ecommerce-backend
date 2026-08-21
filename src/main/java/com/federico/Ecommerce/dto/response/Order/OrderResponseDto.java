package com.federico.Ecommerce.dto.response.Order;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
public class OrderResponseDto {

    private Integer orderId;
    private String orderStatus;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private Integer userId;
}