package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.Service.auth.AuthenticationStrategy;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@MappedSuperclass

public abstract class Utilisateur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String motDePasse;
    @Column(nullable = false)
    private Genre genre;
    @Column(nullable = false)
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(int id, String prenom, String nom, String email, String hashpw, Genre genre, Role role) {
    }
}
