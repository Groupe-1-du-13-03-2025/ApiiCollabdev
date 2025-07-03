package com.example.ApiiCollabdev.Dto;

import com.example.ApiiCollabdev.entities.Contributeur;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Niveau;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContributeurDTO {
    private String nom;
    private String prenom;
    private Niveau niveau;
    private Genre genre;
    //constructeur du dto
    public ContributeurDTO(Contributeur contributeur)
    {
        this.nom = contributeur.getNom();
        this.prenom = contributeur.getPrenom();
        this.niveau = contributeur.getNiveau();
        this.genre = contributeur.getGenre();
    }
}
