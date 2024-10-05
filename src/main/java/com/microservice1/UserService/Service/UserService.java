package com.microservice1.UserService.Service;

import com.microservice1.UserService.Auth.JwtUtil;
import com.microservice1.UserService.Entity.User;
import com.microservice1.UserService.Enum.UserRole;
import com.microservice1.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

//    public User registerUser(String username, String email, String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(passwordEncoder.encode(password));
//        return userRepository.save(user);
//    }

    public User registerUser(String username, String email, String password, UserRole role) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role != null ? role : UserRole.USER); // Default to USER if not provided
        return userRepository.save(user);
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }
        return jwtUtil.generateToken(user.getId().toString());
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found")); // Handle case if not found
    }
}