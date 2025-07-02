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
@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private Boolean estFini;
    private Date dateDebut;
    private Date dateFin;
    private Niveau niveauDacces;

    @ManyToOne
    @JoinColumn(name = "gestionnaire_id")
    private Gestionnaire gestionnaire;

}
