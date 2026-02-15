package com.assignment.ordersystem.service;

import com.assignment.ordersystem.dto.RegisterDTO;
import com.assignment.ordersystem.entity.*;
import com.assignment.ordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;


    public String createAdmin(RegisterDTO dto){

    User admin = User.builder()
            .username(dto.getUsername())
            .password(encoder.encode(dto.getPassword()))
            .role(Role.ROLE_ADMIN)
            .build();

    repo.save(admin);

    return "Admin created";
}

   public String registerUser(RegisterDTO dto){

        User user = User.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        repo.save(user);

        return "User registered successfully";
    }
}
