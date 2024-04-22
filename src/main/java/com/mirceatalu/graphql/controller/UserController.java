package com.mirceatalu.graphql.controller;

import com.mirceatalu.graphql.dto.UpdatedUserInput;
import com.mirceatalu.graphql.dto.UserInput;
import com.mirceatalu.graphql.entity.User;
import com.mirceatalu.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    Iterable<User> users() {
        return userService.getAll();
    }

    @QueryMapping
    Optional<User> userById(@Argument Long id) {
        return userService.findById(id);
    }

    @MutationMapping
    User addUser(@Argument UserInput userInput) {
        return userService.addUser(userInput);
    }

    @MutationMapping
    User updateUser(@Argument UpdatedUserInput updatedUserInput) {
        return userService.updateUser(updatedUserInput);
    }

    @MutationMapping
    void deleteUser(@Argument UpdatedUserInput deletedUserInput) {
        userService.deleteUser(deletedUserInput);
    }
}
