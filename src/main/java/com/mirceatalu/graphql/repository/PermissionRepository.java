package com.mirceatalu.graphql.repository;

import com.mirceatalu.graphql.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByName(String name);
}
