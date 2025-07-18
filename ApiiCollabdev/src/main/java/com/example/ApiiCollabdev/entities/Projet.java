package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Niveau;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Projet {
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String titre;
    private  String description;
    private Boolean estFini;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Niveau niveauDacces;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "gestionnaire_id")
    private Gestionnaire gestionnaire;

}
