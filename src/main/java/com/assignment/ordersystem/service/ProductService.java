package com.assignment.ordersystem.service;

import com.assignment.ordersystem.dto.ProductDTO;
import com.assignment.ordersystem.entity.*;
import com.assignment.ordersystem.exception.ResourceNotFoundException;
import com.assignment.ordersystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final InventoryRepository inventoryRepo;

    // CREATE PRODUCT
    public Product create(ProductDTO dto){

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Product product = productRepo.save(
                Product.builder()
                        .name(dto.getName())
                        .price(dto.getPrice())
                        .category(category)
                        .enabled(true)
                        .build()
        );

        inventoryRepo.save(
                Inventory.builder()
                        .product(product)
                        .quantity(dto.getQuantity())
                        .build()
        );

        return product;
    }

    // ADMIN VIEW ALL PRODUCTS
    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public Product enable(Long id){

    Product product = productRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

    product.setEnabled(true);

    return productRepo.save(product);
}


    // SOFT DELETE
    public Product disable(Long id){

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setEnabled(false);

        return productRepo.save(product);
    }
}
