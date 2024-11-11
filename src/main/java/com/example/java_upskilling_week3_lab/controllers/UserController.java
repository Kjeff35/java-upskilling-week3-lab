package com.example.java_upskilling_week3_lab.controllers;

import com.example.java_upskilling_week3_lab.models.User;
import com.example.java_upskilling_week3_lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController is a Spring MVC controller that manages HTTP requests
 * related to user operations such as retrieving, creating, updating, and deleting users.
 */
@RestController
public class UserController {

    /**
     * The UserService used to handle the business logic for user-related operations.
     */
    @Autowired
    private UserService userService;

    /**
     * Retrieves a list of all users in the system.
     *
     * @return a ResponseEntity containing a list of all users.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    /**
     * Retrieves a user based on their email address.
     *
     * @param email the email address of the user to retrieve.
     * @return a ResponseEntity containing the user with the specified email.
     */
    @GetMapping("/find-user")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    /**
     * Adds a new user to the system.
     *
     * @param user the user object containing the details of the user to be added.
     */
    @PostMapping("/add-user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * Deletes a user based on their email address.
     *
     * @param email the email address of the user to delete.
     */
    @DeleteMapping("/delete-user/{email}")
    public void deleteUserByEmail(@PathVariable String email) {
       userService.deleteUser(email);
    }

    /**
     * Updates an existing user's information based on their email address.
     *
     * @param email the email address of the user to update.
     * @param user the user object containing the updated details.
     */
    @PutMapping("/change-user/{email}")
    public void updateUser(@PathVariable String email, @RequestBody User user) {
        userService.updateUser(email, user);
    }
}
