package com.dioquino.demo.service;

import com.dioquino.demo.Entity.UserEntity;
import com.dioquino.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or update a user
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    // Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<UserEntity> getUserById(int id) {
        return userRepository.findById(id);
    }

    // Delete user by ID
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
