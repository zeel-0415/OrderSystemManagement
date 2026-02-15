package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.entity.Inventory;
import com.assignment.ordersystem.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminInventoryController {

    private final InventoryService service;

    @PostMapping("/restock")
    public Inventory restock(
            @RequestParam Long productId,
            @RequestParam int qty){

        return service.restock(productId, qty);
    }
}
