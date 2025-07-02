package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Gestionnaire extends Utilisateur {
    private String uriCv;
    @Builder
    public Gestionnaire(long id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role, String uriCv) {
        super(id, prenom, nom, email, motDePasse, genre, role);
        this.uriCv = uriCv;

    }
}



