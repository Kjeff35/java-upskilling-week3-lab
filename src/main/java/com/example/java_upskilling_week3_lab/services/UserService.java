package com.example.java_upskilling_week3_lab.services;

import com.example.java_upskilling_week3_lab.models.User;
import com.example.java_upskilling_week3_lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for handling business logic related to users.
 * It interacts with the {@link UserRepository} to perform CRUD operations on User entities.
 */
@Service
public class UserService {

    /**
     * The UserRepository instance used for interacting with the data source.
     */
    @Autowired
    private UserRepository userRepository;


    /**
     * Retrieves a list of all users.
     *
     * @return a list of all users.
     */
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    /**
     * Retrieves a user based on their email address.
     *
     * @param email the email address of the user to retrieve.
     * @return the user with the specified email address, or null if no user is found.
     */
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    /**
     * Adds a new user to the system.
     *
     * @param user the user object containing the user's details.
     */
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    /**
     * Deletes a user from the system based on their email address.
     *
     * @param email the email address of the user to delete.
     */
    public void deleteUser(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            userRepository.removeUser(user);
        }
    }

    /**
     * Updates an existing user based on their email address.
     * If the user exists, their information is replaced with the updated user details.
     *
     * @param email the email address of the user to update.
     * @param updatedUser the user object containing the updated user details.
     */
    public void updateUser(String email, User updatedUser) {
        User existingUser = userRepository.getUserByEmail(email);
        if (existingUser != null) {
            userRepository.removeUser(existingUser);
            userRepository.addUser(updatedUser);
        }
    }
}
