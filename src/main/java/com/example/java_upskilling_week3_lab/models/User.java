package com.example.java_upskilling_week3_lab.models;

/**
 * Represents a user in the system with basic personal details.
 * This class contains the user's name, age, and email address.
 */
public class User {
    private String name;
    private int age;
    private String email;

    /**
     * Constructs a new User with the specified name, email, and age.
     *
     * @param name the name of the user.
     * @param email the email address of the user.
     * @param age the age of the user.
     */
    public User(String name, String email, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
