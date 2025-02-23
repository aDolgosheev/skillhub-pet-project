package com.dolgosheev.skillhubpetproject.config;

import com.dolgosheev.skillhubpetproject.model.Role;
import com.dolgosheev.skillhubpetproject.model.User;
import com.dolgosheev.skillhubpetproject.repository.RoleRepository;
import com.dolgosheev.skillhubpetproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Проверяем, существует ли пользователь с логином "admin"
            if (!userRepository.existsByUsername("admin")) {
                // Создаем роль администратора, если она не существует
                Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                        .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_ADMIN")));

                // Создаем пользователя-админа
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin")); // Пароль будет закодирован BCrypt
                admin.setEmail("admin@example.com");
                admin.getRoles().add(adminRole);
                userRepository.save(admin);

                System.out.println("Default admin created with username: admin and password: admin");
            }
        };
    }
}
