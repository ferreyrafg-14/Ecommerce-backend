package com.federico.Ecommerce.dto.request.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryPutDto {
    @NotBlank(message = "La categoria no puede estar vacia")
    private String categoryName;
}
