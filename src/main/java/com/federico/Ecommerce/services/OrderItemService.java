package com.federico.Ecommerce.services;


import com.federico.Ecommerce.exception.ResourceNotFoundException;
import com.federico.Ecommerce.models.Entity.CartItem;
import com.federico.Ecommerce.models.Entity.Order;
import com.federico.Ecommerce.models.Entity.OrderItem;
import com.federico.Ecommerce.models.Entity.Product;
import com.federico.Ecommerce.models.embeddable.OrderItemId;
import com.federico.Ecommerce.repositories.OrderItemRepository;
import com.federico.Ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public OrderItemService(OrderItemRepository orderItemRepository ,  ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;

    }

    public  List<OrderItem> createOrdersItems(List<CartItem> cartItems , Order order  , Integer productId) {
        List<OrderItem> orderItemsList = new ArrayList<>();


        for(CartItem cartItem : cartItems) {
            /*Product product = productRepository.findById(productId)
                    .orElseThrow(()  -> new ResourceNotFoundException("Produto no encontrado"));*/
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);
            orderItem.setOrderItemId(new OrderItemId());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setUnitPrice(cartItem.getProduct().getPrice());
            orderItemsList.add(orderItem);
            orderItemRepository.save(orderItem);

        }

        return  orderItemsList;


    }
}
