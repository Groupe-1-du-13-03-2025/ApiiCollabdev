package com.example.ApiiCollabdev.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContributionDTO {
    private int id;
    private String titre;
    private String description;
    private Date debutDate;
    private Date finDate;
    private int piecesAGagner;
    private boolean estFini;
    private boolean estValide;

    public ContributionDTO(String titre, String description, Date debutDate, Date finDate, int piecesAGagner,
                           boolean estFini, boolean estValide)
    {
        this.titre = titre;
        this.description = description;
        this.debutDate = debutDate;
        this.finDate = finDate;
        this.piecesAGagner = piecesAGagner;
        this.estFini = estFini;
        this.estValide = estValide;
    }
}
