package com.federico.Ecommerce.dto.request.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryPostDto {
    @NotBlank(message = "El nombre de la categoria es obligatorio")
    private String categoryName;

}
