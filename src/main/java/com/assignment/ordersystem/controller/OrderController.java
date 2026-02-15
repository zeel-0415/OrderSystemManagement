package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.entity.Order;
import com.assignment.ordersystem.entity.OrderItem;
import com.assignment.ordersystem.repository.OrderRepository;
import com.assignment.ordersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    private final OrderRepository orderRepo;

    // Place order
    @PostMapping
    public Order place(@RequestBody List<OrderItem> items){
        return service.placeOrder(items);
    }

    // User sees ONLY their orders
    @GetMapping("/my")
    public List<Order> myOrders(Authentication auth){

        return orderRepo.findByUserUsername(auth.getName());
    }
}
