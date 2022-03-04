package com.TheTrueHooha.SpringSecurityJWT;

import com.TheTrueHooha.SpringSecurityJWT.Models.AppRole;
import com.TheTrueHooha.SpringSecurityJWT.Models.AppUser;
import com.TheTrueHooha.SpringSecurityJWT.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}

	
	@Bean
	PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner (UserService userService) {
		return args -> {
			userService.saveRole(new AppRole(null, "Regulator"));
			userService.saveRole(new AppRole(null, "Moderator"));
			userService.saveRole(new AppRole(null, "ADMIN"));
			userService.saveRole(new AppRole(null, "Contributor"));
			userService.saveRole(new AppRole(null, "Maintainer"));
			userService.saveRole(new AppRole(null, "SuperAdmin"));


			userService.saveUser(new AppUser(null, "John Bean", "john", "1234",
					"johnbean@yahoo.com", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Michael Bean", "mic", "23456",
					"micgreat@yahoo.com", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Grace Bean", "graceG", "true",
					"graceG@yahoo.com", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Purity Bean", "purity", "purity",
					"purity@yahoo.com", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Bella Bean", "bella44", "4433",
					"bella44@yahoo.com", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Annabel Bean", "anna4real", "anna4real123",
					"anna4real@yahoo.com", new ArrayList<>()));

			userService.addRoleToUser("john", "Regulator");
			userService.addRoleToUser("mic", "Moderator");
			userService.addRoleToUser("graceG", "ADMIN");
			userService.addRoleToUser("purity", "Contributor");
			userService.addRoleToUser("bella44", "Maintainer");
			userService.addRoleToUser("anna4real", "SuperAdmin");
		};
	}

}
