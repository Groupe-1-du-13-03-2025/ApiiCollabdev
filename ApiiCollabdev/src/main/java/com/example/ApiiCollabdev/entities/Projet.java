package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Niveau;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Projet {
    @Id
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String titre;
    private  String description;
    private Boolean estFini;
    private Date dateDebut;
    private Date dateFin;
    private Niveau niveauDacces;

@ManyToOne
@JoinColumn(name = "idGestionnaire")       // clé étrangère vers projet
private Utilisateur Gestionnaire;
}
