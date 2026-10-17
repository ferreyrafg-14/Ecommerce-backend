package com.federico.Ecommerce.dto.response.CartItem;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponseDto {
    private Integer cartId;
    private Integer productId;
    private int quantity;
}
