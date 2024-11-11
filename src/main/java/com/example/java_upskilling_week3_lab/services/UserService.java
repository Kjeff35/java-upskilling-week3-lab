package com.example.java_upskilling_week3_lab.services;

import com.example.java_upskilling_week3_lab.models.User;
import com.example.java_upskilling_week3_lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void deleteUser(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            userRepository.removeUser(user);
        }
    }

    public void updateUser(String email, User updatedUser) {
        User existingUser = userRepository.getUserByEmail(email);
        if (existingUser != null) {
            userRepository.removeUser(existingUser);
            userRepository.addUser(updatedUser);
            System.out.println("Hello");
        }
    }
}
