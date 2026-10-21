package com.federico.Ecommerce.dto.response.Order;
import com.federico.Ecommerce.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {


    private Integer orderId;

    private OrderStatus orderStatus;

    private BigDecimal total;

    private LocalDateTime createdAt;

    private Integer userId;
}
