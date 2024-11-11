package com.example.java_upskilling_week3_lab.repositories;

import com.example.java_upskilling_week3_lab.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing users in the system.
 * This interface provides methods to perform CRUD operations
 * on User entities, such as retrieving, adding, and removing users.
 */
@Repository
public interface UserRepository {
    /**
     * Retrieves a list of all users in the system.
     *
     * @return a list of all users.
     */
    List<User> getUsers();

    /**
     * Retrieves a user based on their email address.
     *
     * @param email the email address of the user to retrieve.
     * @return the user with the specified email, or null if no user is found.
     */
    User getUserByEmail(String email);

    /**
     * Adds a new user to the system.
     *
     * @param user the user to add.
     */
    void addUser(User user);

    /**
     * Removes a user from the system.
     *
     * @param user the user to remove.
     */
    void removeUser(User user);
}
