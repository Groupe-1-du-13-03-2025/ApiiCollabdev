package com.example.ApiiCollabdev.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class IdeeProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String titre;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String domaine;
    private String uriCDC;
    private long nombreSoutien;
    @Column(nullable = false)
    private LocalDateTime datePublication;

     @OneToMany(mappedBy = "ideeProjet")
     private List<CommentaireIdeeProjet> commentaires;
}
