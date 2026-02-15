package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.entity.Order;
import com.assignment.ordersystem.entity.User;
import com.assignment.ordersystem.repository.OrderRepository;
import com.assignment.ordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/super")
@RequiredArgsConstructor
public class SuperAdminController {

    private final UserRepository userRepo;
    private final OrderRepository orderRepo;

    @GetMapping("/users")
    public List<User> allUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/orders")
    public List<Order> allOrders(){
        return orderRepo.findAll();
    }
}
