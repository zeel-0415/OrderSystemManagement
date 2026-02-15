package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.entity.Product;
import com.assignment.ordersystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repo;

    // Only enabled products visible to users
    @GetMapping("/products")
    public List<Product> getEnabledProducts(){
        return repo.findByEnabledTrue();
    }
}
