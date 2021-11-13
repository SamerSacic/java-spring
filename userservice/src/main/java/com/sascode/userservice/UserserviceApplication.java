package com.sascode.userservice;

import com.sascode.userservice.domain.Role;
import com.sascode.userservice.domain.User;
import com.sascode.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserserviceApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Samer Sacic", "samer", "1234567", new ArrayList<>()));
			userService.saveUser(new User(null, "John Doe", "john", "1234567", new ArrayList<>()));
			userService.saveUser(new User(null, "Jane Doe", "jane", "1234567", new ArrayList<>()));

			userService.saveRoleToUser("john", "ROLE_USER");
			userService.saveRoleToUser("samer", "ROLE_SUPER_ADMIN");
			userService.saveRoleToUser("samer", "ROLE_ADMIN");
			userService.saveRoleToUser("samer", "ROLE_MANAGER");
			userService.saveRoleToUser("jane", "ROLE_MANAGER");
		};
	}
}
