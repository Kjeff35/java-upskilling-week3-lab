package com.example.java_upskilling_week3_lab;

import com.example.java_upskilling_week3_lab.models.User;
import com.example.java_upskilling_week3_lab.repositories.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaUpskillingWeek3LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaUpskillingWeek3LabApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository) {

		return args -> createUser(userRepository);
	}

	private void createUser(UserRepository userRepository) {
		for (int i = 1; i < 5; i++) {
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String name = firstName + " " + lastName;
			String email = (firstName + "." + lastName + "@gmail.com");
			int age = faker.number().numberBetween(20, 50);
			User user = new User(name, email, age);
			userRepository.addUser(user);
		}
	}


}
