package com.federico.Ecommerce.controllers;
import com.federico.Ecommerce.dto.request.Product.ProductRequestDto;
import com.federico.Ecommerce.dto.response.Product.ProductResponseDto;
import com.federico.Ecommerce.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@Tag(name = "Productos", description = "Operaciones CRUD sobre el catálogo de productos")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
            this.service = service;
    }

    @Operation(
            summary = "Crear un producto",
            description = "Crea un nuevo producto a partir de los datos recibidos en el body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado correctamente",
                    content = @Content(schema = @Schema(implementation = ProductResponseDto.class))),

            @ApiResponse(responseCode = "400", description = "Datos no validos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto dto) {
        ProductResponseDto response = service.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Operation(
            summary = "Actualizar parcialmente un producto",
            description = "Actualiza uno o varios campos del producto indicado por ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente",
                    content = @Content(schema = @Schema(implementation = ProductResponseDto.class))),

            @ApiResponse(responseCode = "400", description = "Datos no validos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),

            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })


    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto>  updateProduct(@Valid @PathVariable int id, @RequestBody ProductRequestDto dto) {
        ProductResponseDto response = service.updateProduct(id , dto);
        return ResponseEntity.ok(response);

    }

    @Operation(
            summary = "Reemplazar un producto",
            description = "Reemplaza completamente los datos del producto indicado por ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto reemplazado correctamente",
                    content = @Content(schema = @Schema(implementation = ProductResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> putProduct(@Valid @PathVariable int id, @RequestBody ProductRequestDto dto) {
        ProductResponseDto response = service.putProduct(id , dto);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Listar todos los productos",
            description = "Devuelve la lista completa de productos existentes."
    )
    @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAllProducts() {
        List<ProductResponseDto> response = service.findAllProducts();
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Buscar un producto por ID",
            description = "Devuelve los datos del producto correspondiente al ID indicado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = @Content(schema = @Schema(implementation = ProductResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findProductById(@PathVariable int id) {
        ProductResponseDto response = service.findProductById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Eliminar un producto",
            description = "Elimina el producto indicado por ID y devuelve sus datos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente",
                    content = @Content(schema = @Schema(implementation = ProductResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable int id) {
        ProductResponseDto response = service.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

}
