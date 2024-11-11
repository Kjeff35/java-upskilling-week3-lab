package com.example.java_upskilling_week3_lab.services;

import com.example.java_upskilling_week3_lab.models.User;
import com.example.java_upskilling_week3_lab.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUsers() {
        User user1 = new User("Test", "test@example.com", 23);
        User user2 = new User("Test2", "test2@example.com", 23);

        when(userRepository.getUsers()).thenReturn(List.of(user1, user2));

        List<User> users = userService.getUsers();

        assertEquals(2, users.size());
        assertEquals("Test", users.get(0).getName());
        assertEquals("Test2", users.get(1).getName());

        verify(userRepository, times(1)).getUsers();
    }

    @Test
    void testGetUserByEmail() {
        User user = new User("Test", "test@example.Com", 23);
        when(userRepository.getUserByEmail("test@example.com")).thenReturn(user);

        User result = userService.getUserByEmail("test@example.com");

        assertNotNull(result);
        assertEquals("Test", result.getName());
        verify(userRepository, times(1)).getUserByEmail("test@example.com");
    }

    @Test
    void testAddUser() {
        User user = new User("test", "test@example.Com", 23);

        userService.addUser(user);

        verify(userRepository, times(1)).addUser(user);
    }

    @Test
    void testDeleteUser() {
        User user = new User("test", "test@example.Com", 23);

        when(userRepository.getUserByEmail("test@example.com")).thenReturn(user);

        userService.deleteUser("test@example.com");

        verify(userRepository, times(1)).removeUser(user);
    }

    @Test
    void testDeleteUser_UserNotFound() {
        when(userRepository.getUserByEmail("nonexistent@example.com")).thenReturn(null);

        userService.deleteUser("nonexistent@example.com");

        verify(userRepository, never()).removeUser(any(User.class));
    }

    @Test
    void testUpdateUser() {
        User existingUser = new User("test", "test@example.Com", 23);
        User updatedUser = new User("test", "test@example.Com", 23);

        when(userRepository.getUserByEmail("test@example.com")).thenReturn(existingUser);

        userService.updateUser("test@example.com", updatedUser);

        verify(userRepository, times(1)).removeUser(existingUser);
        verify(userRepository, times(1)).addUser(updatedUser);
    }

    @Test
    void testUpdateUser_UserNotFound() {
        User updatedUser = new User("test", "test@example.Com", 23);

        when(userRepository.getUserByEmail("nonexistent@example.com")).thenReturn(null);

        userService.updateUser("nonexistent@example.com", updatedUser);

        verify(userRepository, never()).removeUser(any(User.class));
        verify(userRepository, never()).addUser(updatedUser);
    }
}