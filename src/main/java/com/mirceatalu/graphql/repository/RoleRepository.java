package com.mirceatalu.graphql.repository;

import com.mirceatalu.graphql.entity.Role;
import com.mirceatalu.graphql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByUser(User user);
}
