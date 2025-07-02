package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Gestionnaire extends Utilisateur {
    private String uriCv;
    @Builder
    public Gestionnaire(int id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role, String uriCv) {
        super(id, prenom, nom, email, motDePasse, genre, role);
        this.uriCv = uriCv;

    }

    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL)
    private List<Projet> projets = new ArrayList<>();
}



