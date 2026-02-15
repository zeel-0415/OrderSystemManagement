package com.assignment.ordersystem.service;

import com.assignment.ordersystem.entity.*;
import com.assignment.ordersystem.exception.*;
import com.assignment.ordersystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryRepository inventoryRepo;
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    public Order placeOrder(List<OrderItem> items){

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        User user = userRepo.findByUsername(auth.getName())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        double total = 0;

        for(OrderItem item : items){

            Inventory inventory = inventoryRepo.findByProductId(item.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));

            Product product = inventory.getProduct();

            // ✅ CHECK IF PRODUCT DISABLED
            if(!product.isEnabled()){
                throw new ProductDisabledException(
                        product.getName() + " is currently disabled"
                );
            }

            // ✅ CHECK STOCK
            if(inventory.getQuantity() < item.getQuantity()){
                throw new InsufficientInventoryException(
                        "Only " + inventory.getQuantity() + " items available"
                );
            }

            // ✅ REDUCE STOCK
            inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
            inventoryRepo.save(inventory);

            total += product.getPrice() * item.getQuantity();
        }

        // ✅ CREATE ORDER (YOU WERE MISSING THIS)
        Order order = Order.builder()
                .items(items)
                .totalAmount(total)
                .user(user)
                .build();

        return orderRepo.save(order);
    }
}
