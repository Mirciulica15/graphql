package com.mirceatalu.graphql.service;

import com.mirceatalu.graphql.dto.RoleInput;
import com.mirceatalu.graphql.dto.UserInput;
import com.mirceatalu.graphql.entity.Role;
import com.mirceatalu.graphql.entity.User;
import com.mirceatalu.graphql.repository.RoleRepository;
import com.mirceatalu.graphql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public List<Role> getByUser(UserInput userInput) {
        User user = userRepository.findByEmail(userInput.email());
        return roleRepository.findAllByUser(user);
    }

    public Role addRole(RoleInput roleInput) {
        User user = userRepository.findByEmail(roleInput.userInput().email());
        Role role = new Role(user, roleInput.role());
        return roleRepository.save(role);
    }
}
