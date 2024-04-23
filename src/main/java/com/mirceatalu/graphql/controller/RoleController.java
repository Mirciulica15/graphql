package com.mirceatalu.graphql.controller;

import com.mirceatalu.graphql.dto.RoleInput;
import com.mirceatalu.graphql.dto.UserInput;
import com.mirceatalu.graphql.entity.Role;
import com.mirceatalu.graphql.service.RoleService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @QueryMapping
    Iterable<Role> roles() {
        return roleService.getAll();
    }

    @QueryMapping
    Iterable<Role> rolesByUser(@Argument UserInput userInput) {
        return roleService.getByUser(userInput);
    }

    @MutationMapping
    Role addRole(@Argument RoleInput roleInput) {
        return roleService.addRole(roleInput);
    }


}
