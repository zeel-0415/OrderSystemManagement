package com.assignment.ordersystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
private User user;

    private double totalAmount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
