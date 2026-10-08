package com.federico.Ecommerce.controllers;

import com.federico.Ecommerce.dto.request.Category.CategoryPatchDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPostDto;
import com.federico.Ecommerce.dto.request.Category.CategoryPutDto;
import com.federico.Ecommerce.dto.response.Category.CategoryResponseDto;
import com.federico.Ecommerce.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @Operation(summary = " Registrar nueva categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = " Categoria creada correctamente" ,
            content = @Content(schema = @Schema(implementation = CategoryResponseDto.class))),

            @ApiResponse(responseCode = "404" , description = "Datos no validos" ,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryPostDto dto){
        CategoryResponseDto response = service.createCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @Operation(summary = "Actualizar parcialmente una categoria",
            description = "Actualiza únicamente los campos enviados en el body, dejando el resto sin modificar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria actualizada correctamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDto.class))),

            @ApiResponse(responseCode = "404", description = "Categoria no encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),

            @ApiResponse(responseCode = "400", description = "Datos no validos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Integer id ,@RequestBody CategoryPatchDto dto){
       CategoryResponseDto response =  service.UpdateCategory(dto,id);

       return  ResponseEntity.ok(response);

    }

    @Operation(summary = "Reemplazar una categoria",
            description = "Reemplaza completamente los datos de la categoria indicada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria reemplazada correctamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDto.class))),

            @ApiResponse(responseCode = "404", description = "Categoria no encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),

            @ApiResponse(responseCode = "400", description = "Datos no validos",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> replaceCategory(@PathVariable Integer id,@RequestBody CategoryPutDto dto){
        CategoryResponseDto response = service.replaceCategory(id , dto);
        return  ResponseEntity.ok(response);
    }

    @Operation(summary = "Listar todas las categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDto.class)))
    })
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        List<CategoryResponseDto> response = service.getAllCategories();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener una categoria por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDto.class))),

            @ApiResponse(responseCode = "404", description = "Categoria no encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Integer id){
        CategoryResponseDto response = service.getCategoryById(id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Eliminar una categoria",
            description = "Elimina la categoria indicada y devuelve los datos de la categoria eliminada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria eliminada correctamente",
                    content = @Content(schema = @Schema(implementation = CategoryResponseDto.class))),

            @ApiResponse(responseCode = "404", description = "Categoria no encontrada",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable Integer id){

        CategoryResponseDto response =  service.deleteCategory(id);
        return ResponseEntity.ok(response);
    }
}
