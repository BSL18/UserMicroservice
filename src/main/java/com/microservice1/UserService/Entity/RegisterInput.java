package com.microservice1.UserService.Entity;

import com.microservice1.UserService.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInput {
    private String username;
    private String email;
    private String password;
    private UserRole role;

    // Getters and Setters
}

