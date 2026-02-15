package com.assignment.ordersystem.controller;

import com.assignment.ordersystem.entity.Category;
import com.assignment.ordersystem.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository repo;

    @PostMapping
    public Category create(@RequestBody Category category){
        return repo.save(category);
    }

    @GetMapping
    public Object all(){
        return repo.findAll();
    }
}
