package com.sindhu.promotionmanager.service;

import com.sindhu.promotionmanager.model.User;
import com.sindhu.promotionmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    public User loginUser(User user){
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {
            User foundUser = existingUser.get();

            if (foundUser.getPassword().equals(user.getPassword())) {
                return foundUser;
            }
        }

        throw new RuntimeException("Invalid email or password");
    }
}
