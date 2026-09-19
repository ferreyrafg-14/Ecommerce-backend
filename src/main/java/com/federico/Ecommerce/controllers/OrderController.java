package com.federico.Ecommerce.controllers;




import com.federico.Ecommerce.dto.request.Order.OrderRequestDto;
import com.federico.Ecommerce.dto.response.Order.OrderResponseDto;
import com.federico.Ecommerce.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderRequestDto dto) {
        OrderResponseDto response = service.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderResponseDto>  updateOrder(@Valid @PathVariable int id, @RequestBody OrderRequestDto dto) {
        OrderResponseDto response = service.updateOrder(id , dto);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> putOrder(@Valid @PathVariable int id, @RequestBody OrderRequestDto dto) {
        OrderResponseDto response = service.putOrder(id , dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> findAllOrders() {
        List<OrderResponseDto> response = service.findAllOrders();
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> findOrderById(@PathVariable int id) {
        OrderResponseDto response = service.findOrderById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDto> deleteOrder(@PathVariable int id) {
        OrderResponseDto response = service.deleteOrder(id);
        return ResponseEntity.ok(response);
    }

}