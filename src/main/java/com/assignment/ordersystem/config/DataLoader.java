package com.assignment.ordersystem.config;

import com.assignment.ordersystem.entity.Role;
import com.assignment.ordersystem.entity.User;
import com.assignment.ordersystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {

        if(repo.findByUsername("superadmin").isEmpty()){

            User superAdmin = User.builder()
                    .username("superadmin")
                    .password(encoder.encode("super123"))
                    .role(Role.ROLE_SUPER_ADMIN)
                    .build();

            repo.save(superAdmin);
        }
    }
}
