package com.example.ApiiCollabdev;

import com.example.ApiiCollabdev.Repository.ContributeurRepository;
import com.example.ApiiCollabdev.entities.Contributeur;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Niveau;
import com.example.ApiiCollabdev.entities.enums.Role;
import com.example.ApiiCollabdev.entities.enums.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class ApiiCollabdevApplication {

	@Autowired
	private static ContributeurRepository contributeurRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiiCollabdevApplication.class, args);
	}

}
