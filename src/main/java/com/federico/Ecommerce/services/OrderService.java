package com.federico.Ecommerce.services;


import com.federico.Ecommerce.dto.request.Order.OrderRequestDto;
import com.federico.Ecommerce.dto.response.Order.OrderResponseDto;
import com.federico.Ecommerce.enums.OrderStatus;
import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.mapper.OrderMapper;
import com.federico.Ecommerce.models.Entity.*;
import com.federico.Ecommerce.repositories.CartRepository;
import com.federico.Ecommerce.repositories.OrderRepository;
import com.federico.Ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderItemService orderItemService;

    public  OrderService(OrderRepository repository , UserRepository userRepository , OrderMapper mapper ,  CartRepository cartRepository ,  OrderItemService orderItemService ) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.cartRepository = cartRepository;
        this.orderItemService = orderItemService;
    }

    //POST
    public OrderResponseDto createOrder(OrderRequestDto dto ) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Cart cart = cartRepository.findById(dto.getCartId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrito no encontrado"));


        Order order = mapper.toEntity(dto);

        order.setOrderStatus(OrderStatus.PENDING);
        order.setUser(user);
        order.setTotal(BigDecimal.ZERO);
        Order saveOrder = repository.save(order);

        List<OrderItem> orderItemList =  orderItemService.createOrdersItems(cart.getCartItems() , saveOrder , dto.getProductId());


        BigDecimal total = BigDecimal.ZERO;
        for( OrderItem orderItem : orderItemList){
            total = total.add(orderItem.getUnitPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()))) ;

        }
        saveOrder.setTotal(total);
        repository.save(saveOrder);
        return mapper.toResponseDto(saveOrder);
    }

    /*
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

     */


}