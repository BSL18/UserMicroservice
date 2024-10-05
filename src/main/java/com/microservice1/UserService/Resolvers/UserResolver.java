package com.microservice1.UserService.Resolvers;

import com.microservice1.UserService.Entity.AuthData;
import com.microservice1.UserService.Entity.LoginInput;
import com.microservice1.UserService.Entity.RegisterInput;
import com.microservice1.UserService.Entity.User;
import com.microservice1.UserService.Enum.UserRole;
import com.microservice1.UserService.Service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private UserService userService;

    public User registerUser(RegisterInput input) {
        return userService.registerUser(input.getUsername(), input.getEmail(), input.getPassword(), input.getRole());
    }

    public AuthData loginUser(LoginInput input) {
        String token = userService.loginUser(input.getEmail(), input.getPassword());
        return new AuthData(userService.findByEmail(input.getEmail()).getId(), token, 3600);
    }

    public User getUser(Long id) {
        return userService.getUserById(id);
    }
}
