package com.mirceatalu.graphql.service;

import com.mirceatalu.graphql.dto.UserInput;
import com.mirceatalu.graphql.entity.User;
import com.mirceatalu.graphql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(UserInput userInput) {
        User user = new User(userInput.name(), userInput.email());
        return userRepository.save(user);
    }

    public User updateUser(UserInput userInput) {
        User user = userRepository.findByEmail(userInput.email());
        user.setName(userInput.name());
        return userRepository.save(user);
    }

    public void deleteUser(UserInput userInput) {
        User user = userRepository.findByEmail(userInput.email());
        userRepository.delete(user);
    }
}
