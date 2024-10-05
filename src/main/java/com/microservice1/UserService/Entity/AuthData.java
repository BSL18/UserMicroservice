package com.microservice1.UserService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthData {
    private Long userId;
    private String token;
    private int tokenExpiration;
    // Getters and Setters
}
