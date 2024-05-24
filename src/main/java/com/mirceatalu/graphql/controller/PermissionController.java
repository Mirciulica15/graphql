package com.mirceatalu.graphql.controller;

import com.mirceatalu.graphql.dto.PermissionInput;
import com.mirceatalu.graphql.entity.Permission;
import com.mirceatalu.graphql.service.PermissionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PermissionController {
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @QueryMapping
    Iterable<Permission> permissions() {
        return permissionService.getAll();
    }

    @QueryMapping
    Optional<Permission> permissionById(@Argument Long id) {
        return permissionService.findById(id);
    }

    @MutationMapping
    Permission addPermission(@Argument PermissionInput permissionInput) {
        return permissionService.addPermission(permissionInput);
    }

    @MutationMapping
    Permission updatePermission(@Argument PermissionInput permissionInput) {
        return permissionService.updatePermission(permissionInput);
    }

    @MutationMapping
    void deletePermission(@Argument PermissionInput permissionInput) {
        permissionService.deletePermission(permissionInput);
    }
}
