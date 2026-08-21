package com.federico.Ecommerce.services;


import com.federico.Ecommerce.dto.request.Order.OrderRequestDto;
import com.federico.Ecommerce.dto.response.Order.OrderResponseDto;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.OrderMapper;
import com.federico.Ecommerce.models.Entity.Order;
import com.federico.Ecommerce.models.Entity.User;
import com.federico.Ecommerce.repositories.OrderRepository;
import com.federico.Ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final UserRepository userRepository;
    public  OrderService(OrderRepository repository , OrderMapper mapper , UserRepository userRepository ) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;

    }

    //POST
    public OrderResponseDto createOrder(OrderRequestDto dto ) {
        User userId = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Order entity = mapper.toEntity(dto);
        entity.setUser(userId);

        Order saveOrder = repository.save(entity);
        return mapper.toDto(saveOrder);
    }

    //PATCH
    public OrderResponseDto updateOrder(Integer id ,  OrderRequestDto dto) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        mapper.updateOrderFromDto(dto , order);
        Order savedOrder = repository.save(order);
        return mapper.toDto(savedOrder);
    }

    //PUT
    public OrderResponseDto putOrder(Integer id , OrderRequestDto dto) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        mapper.updateOrderFromDto(dto , entity);
        repository.save(entity);

        return mapper.toDto(entity);
    }
    //GET ALL

    public List<OrderResponseDto> findAllOrders(){
        List<Order> orders = repository.findAll();
        List<OrderResponseDto> dtos = new ArrayList<>();

        for(Order order : orders){
            dtos.add(mapper.toDto(order));
        }

        return dtos;
    }

    //GET
    public OrderResponseDto findOrderById(int id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        return mapper.toDto(order);
    }

    //DELETE
    public OrderResponseDto deleteOrder(Integer id) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));

        OrderResponseDto responseDto = mapper.toDto(order);

        repository.deleteById(id);

        return responseDto;
    }
}