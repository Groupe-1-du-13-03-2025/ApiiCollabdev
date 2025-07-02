package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Niveau;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Projet {
    @Id
<<<<<<< HEAD
    private long id;
=======
>>>>>>> 306c65d7023cbdced56057c21a45621c5cb6f9ba
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private Boolean estFini;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Niveau niveauDacces;

    @ManyToOne
    @JoinColumn(name = "idGestionnaire")       // clé étrangère vers projet
<<<<<<< HEAD
    private Utilisateur gestionnaire;
=======
    private Gestionnaire gestionnaire;
>>>>>>> 306c65d7023cbdced56057c21a45621c5cb6f9ba
}
