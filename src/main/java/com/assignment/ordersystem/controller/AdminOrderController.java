package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.entity.Order;
import com.assignment.ordersystem.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminOrderController {

    private final OrderRepository orderRepo;

    @GetMapping("/orders")
    public List<Order> allOrders(){
        return orderRepo.findAll();
    }
}
