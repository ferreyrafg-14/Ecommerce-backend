package com.federico.Ecommerce.services;
import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.ProductMapper;
import com.federico.Ecommerce.models.Entity.Category;
import com.federico.Ecommerce.models.Entity.Product;
import com.federico.Ecommerce.repositories.CategoryRepository;
import com.federico.Ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;
    public  ProductService(ProductRepository repository ,ProductMapper mapper ,  CategoryRepository categoryRepository ) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoryRepository = categoryRepository;

    }

    //POST
    public ProductResponseDto createProduct(ProductRequestDto dto ) {
        Category categoryId = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));

        Product entity = mapper.toEntity(dto);
        entity.setCategory(categoryId);

        Product saveProduct = repository.save(entity);
        return mapper.toDto(saveProduct);
    }
}
