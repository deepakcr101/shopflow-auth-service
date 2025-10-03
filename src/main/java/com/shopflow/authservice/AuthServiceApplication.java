package com.shopflow.authservice;

import com.shopflow.authservice.model.ERole;
import com.shopflow.authservice.model.Role;
import com.shopflow.authservice.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ComponentScan(basePackages = { "com.shopflow.authservice", "com.shopflow.authservice.config" })
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(RoleRepository roleRepository) {
        return (args) -> {
            if (roleRepository.findByName(ERole.ROLE_USER).isEmpty()) {
                roleRepository.save(new Role(ERole.ROLE_USER));
            }
            if (roleRepository.findByName(ERole.ROLE_MODERATOR).isEmpty()) {
                roleRepository.save(new Role(ERole.ROLE_MODERATOR));
            }
            if (roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty()) {
                roleRepository.save(new Role(ERole.ROLE_ADMIN));
            }
        };
    }
}
