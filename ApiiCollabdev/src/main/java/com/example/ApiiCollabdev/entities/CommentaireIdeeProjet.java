package com.example.ApiiCollabdev.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentaireIdeeProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contenu;
    private LocalDateTime dateCommentaire;

//    @ManyToOne
//    @JoinColumn(name ="idUtilisateur")
//    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="idIdeeProjet")
    private IdeeProjet ideeProjet;
}
