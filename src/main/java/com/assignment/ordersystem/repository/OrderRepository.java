package com.assignment.ordersystem.repository;

import com.assignment.ordersystem.entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserUsername(String username);

}
