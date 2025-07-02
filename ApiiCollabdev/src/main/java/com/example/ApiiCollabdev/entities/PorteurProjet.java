package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "porteur_projet")
public class PorteurProjet extends Utilisateur{


    public PorteurProjet() {
    }
    public PorteurProjet(long id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role) {
        super(id, prenom, nom, email, motDePasse, genre, role);
    }

}
