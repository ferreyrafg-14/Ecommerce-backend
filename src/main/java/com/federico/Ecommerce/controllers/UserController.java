package com.federico.Ecommerce.controllers;
import com.federico.Ecommerce.dto.request.User.UserPatchDto;
import com.federico.Ecommerce.dto.request.User.UserPutDto;
import com.federico.Ecommerce.dto.request.User.UserRequestDto;
import com.federico.Ecommerce.dto.response.User.UserResponseDto;
import com.federico.Ecommerce.exception.ErrorResponse;
import com.federico.Ecommerce.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(name = "Users" , description = "Gestión de usuarios")
@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Operation(summary = "Registra un usuario nuevo")
    @ApiResponses({
            @ApiResponse(responseCode = "201" , description = "Usuario creado correctamente",
            content = @Content(schema = @Schema(implementation = UserResponseDto.class ))),

            @ApiResponse(responseCode = "400" , description = "Datos no validos(campos faltantes" ,
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
            @Valid @RequestBody UserRequestDto dto) {

        UserResponseDto response = service.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Obtener todos los usuarios",
            description = "Devuelve una lista con todos los usuarios registrados en el sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de usuarios obtenida correctamente",
                    content = @Content(
                            array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        List<UserResponseDto> response = service.getAllUsers();

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Obtener un usuario por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200" , description = "Usuario encontrado correctamente" ,
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))),

            @ApiResponse(responseCode = "404" , description = "Usuario no encontrado",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {

        UserResponseDto response = service.getUserById(id);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar usuario completo",
            description = "Reemplaza por completo los datos de un usuario existente. Todos los campos del DTO deben enviarse."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario actualizado correctamente",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos en el cuerpo de la solicitud",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Integer id,
            @RequestBody UserPutDto dto) {

        UserResponseDto response = service.updateUser(id, dto);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Actualizar usuario parcialmente",
            description = "Actualiza uno o más campos de un usuario existente. Solo los campos enviados en el cuerpo serán modificados; el resto se mantiene sin cambios."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario actualizado correctamente",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos inválidos en el cuerpo de la solicitud",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> patchUser(
            @PathVariable Integer id,
            @RequestBody UserPatchDto dto) {

        UserResponseDto response = service.patchUser(id, dto);

        return ResponseEntity.ok(response);
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    */

    @Operation(
            summary = "Eliminar usuario",
            description = "Elimina un usuario existente a partir de su ID y devuelve los datos del usuario eliminado."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuario eliminado correctamente",
                    content = @Content(schema = @Schema(implementation = UserResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUserById(@PathVariable Integer id) {

        UserResponseDto response = service.deleteUserById(id);

        return ResponseEntity.ok(response);
    }
}