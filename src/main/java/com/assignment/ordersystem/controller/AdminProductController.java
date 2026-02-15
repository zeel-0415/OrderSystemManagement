package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.dto.ProductDTO;
import com.assignment.ordersystem.entity.Product;
import com.assignment.ordersystem.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService service;

    // Create product
    @PostMapping
    public Product create(@Valid @RequestBody ProductDTO dto){
        return service.create(dto);
    }

    // View all products (including disabled)
    @GetMapping
    public List<Product> all(){
        return service.getAll();
    }

    @PatchMapping("/{id}/enable")
public Product enable(@PathVariable Long id){
    return service.enable(id);
}


    // Disable product (Soft delete)
    @PatchMapping("/{id}/disable")
    public Product disable(@PathVariable Long id){
        return service.disable(id);
    }
}
