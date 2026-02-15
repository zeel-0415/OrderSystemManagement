package com.assignment.ordersystem.service;

import com.assignment.ordersystem.entity.Inventory;
import com.assignment.ordersystem.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repo;

    public Inventory restock(Long productId, int qty){

        Inventory inv = repo.findByProductId(productId)
                .orElseThrow();

        inv.setQuantity(inv.getQuantity() + qty);

        return repo.save(inv);
    }
}
