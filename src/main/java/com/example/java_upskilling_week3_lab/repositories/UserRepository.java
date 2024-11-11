package com.example.java_upskilling_week3_lab.repositories;

import com.example.java_upskilling_week3_lab.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    List<User> getUsers();

    User getUserByEmail(String email);

    void addUser(User user);

    void removeUser(User user);
}
