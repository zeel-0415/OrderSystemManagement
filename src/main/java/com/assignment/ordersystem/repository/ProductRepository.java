package com.assignment.ordersystem.repository;

import com.assignment.ordersystem.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

                List<Product> findByEnabledTrue();
   
}
