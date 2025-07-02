package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Entity

public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;
    private Genre genre;
    private Role role;

}
