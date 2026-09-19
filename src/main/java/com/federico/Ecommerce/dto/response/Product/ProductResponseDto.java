package com.federico.Ecommerce.dto.response.Product;

import com.federico.Ecommerce.models.Entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductResponseDto {

    private Integer productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;
    private Integer categoryId;

}