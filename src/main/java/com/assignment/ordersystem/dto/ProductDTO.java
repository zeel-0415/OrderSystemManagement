package com.assignment.ordersystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank(message = "Product name required")
    private String name;

    @Positive(message = "Price must be greater than zero")
    private double price;

    private int quantity;

    private Long categoryId;
}
