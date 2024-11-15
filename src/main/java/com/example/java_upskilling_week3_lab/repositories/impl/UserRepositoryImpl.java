package com.example.java_upskilling_week3_lab.repositories.impl;

import com.example.java_upskilling_week3_lab.models.User;
import com.example.java_upskilling_week3_lab.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * {@inheritDoc}
     */
    public User getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    public void removeUser(User user) {
        users.remove(user);
    }
}
