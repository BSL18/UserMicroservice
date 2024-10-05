package com.microservice1.UserService.Entity;

import com.microservice1.UserService.Enum.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password; // Store hashed passwords only

    @Enumerated(EnumType.STRING)
    private UserRole role; // For example, "USER" or "ADMIN"

}

