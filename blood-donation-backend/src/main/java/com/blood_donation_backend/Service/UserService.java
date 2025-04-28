package com.blood_donation_backend.Service;

import com.blood_donation_backend.Entity.UserEntity;
import com.blood_donation_backend.Repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
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
        if(userRepository.existsByEmail(userEntity.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }

        if(!isValidPassword(userEntity.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one number");
        }

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

    public boolean isValidPassword(String password){
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password != null && password.matches(pattern);
    }

    public UserEntity loginUserWithCredentials(String email, String password){
        Optional<UserEntity> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        UserEntity user = optionalUser.get();

        if(!user.getPassword().equals(password)){
            throw new IllegalArgumentException("Invalid password");
        }

        return user;
    }

}
