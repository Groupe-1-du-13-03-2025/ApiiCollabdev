package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Niveau;
import com.example.ApiiCollabdev.entities.enums.Role;
import com.example.ApiiCollabdev.entities.enums.Type;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
public class Contributeur extends Utilisateur {
    @Column(nullable = false)
    private Niveau niveau;
    @Column(nullable = false)
    private Type type;
    @Column(nullable = false)
    private String specialite;
    @Column(nullable = false)
    private Double pieces;
    @Column(nullable = false)
    private String uriCV;

    @ManyToMany
    @JoinTable(
            name = "Contribution",
            joinColumns = @JoinColumn(name = "contributeur_id"),
            inverseJoinColumns = @JoinColumn(name = "projet_id")
    )
    private List<Projet> listProjet;

    @Builder
    public Contributeur(
            int id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role,
            Niveau niveau, Type type, String specialite, Double pieces, String uriCV)
    {
        super(id, prenom, nom, email, motDePasse, genre, role);
        this.niveau = niveau;
        this.type = type;
        this.specialite = specialite;
        this.pieces = pieces;
        this.uriCV = uriCV;
    }
}
