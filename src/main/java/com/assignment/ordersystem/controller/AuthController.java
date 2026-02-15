package com.assignment.ordersystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ordersystem.dto.RegisterDTO;
import com.assignment.ordersystem.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;


    @PostMapping("/super/create-admin")
public String createAdmin(@RequestBody RegisterDTO dto){
    return service.createAdmin(dto);
}


    @PostMapping("/signup")
    public String signup(@RequestBody RegisterDTO dto){
        return service.registerUser(dto);
    }
}
