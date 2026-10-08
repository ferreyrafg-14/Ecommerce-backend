package com.federico.Ecommerce.services;
import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.dto.response.User.UserResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.ProductMapper;
import com.federico.Ecommerce.models.Entity.Category;
import com.federico.Ecommerce.models.Entity.Product;
import com.federico.Ecommerce.models.Entity.User;
import com.federico.Ecommerce.repositories.CategoryRepository;
import com.federico.Ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    //PATCH
    public ProductResponseDto updateProduct(Integer id ,  ProductRequestDto dto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        mapper.updateProductFromDto(dto , product);
        Product savedProduct = repository.save(product);
        return mapper.toDto(savedProduct);
    }

    //PUT
    public ProductResponseDto putProduct(Integer id , ProductRequestDto dto) {
        Product entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        mapper.updateProductFromDto(dto , entity);

        repository.save(entity);

        return mapper.toDto(entity);
    }
    //GET ALL

    public List<ProductResponseDto> findAllProducts(){
        List<Product> products = repository.findAll();
        List<ProductResponseDto> dtos = new ArrayList<>();

        for(Product product : products){
            dtos.add(mapper.toDto(product));
        }

        return dtos;
    }

    //GET
    public ProductResponseDto findProductById(int id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        return mapper.toDto(product);
    }

    //DELETE
    public ProductResponseDto deleteProduct(Integer id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        ProductResponseDto responseDto = mapper.toDto(product);

        repository.deleteById(id);

        return responseDto;
    }
}