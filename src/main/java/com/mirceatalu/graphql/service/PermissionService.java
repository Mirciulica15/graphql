package com.mirceatalu.graphql.service;

import com.mirceatalu.graphql.dto.PermissionInput;
import com.mirceatalu.graphql.entity.Permission;
import com.mirceatalu.graphql.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> findById(Long id) {
        return permissionRepository.findById(id);
    }

    public Permission addPermission(PermissionInput permissionInput) {
        Permission permission = new Permission(permissionInput.name(), permissionInput.description());
        return permissionRepository.save(permission);
    }

    public Permission updatePermission(PermissionInput permissionInput) {
        Permission permission = permissionRepository.findByName(permissionInput.name());
        permission.setName(permissionInput.name());
        return permissionRepository.save(permission);
    }

    public void deletePermission(PermissionInput permissionInput) {
        Permission permission = permissionRepository.findByName(permissionInput.name());
        permissionRepository.delete(permission);
    }
}
