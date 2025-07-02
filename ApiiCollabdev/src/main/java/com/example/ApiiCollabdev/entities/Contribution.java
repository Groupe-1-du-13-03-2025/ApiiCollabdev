package com.example.ApiiCollabdev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Contribution {
    private int id;
    private String titre;
    private String description;
    private Date debutDate;
    private Date finDate;
    private boolean estFini;
    private boolean estValide;
    /*
    //CREER une instance de la classe ContributionId
    ContributionId contributionId = new ContributionId();*/

    @ManyToOne
    @JoinColumn(name = "contributeur_id")
    private Contributeur contributeur;
    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    public Contribution() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDebutDate() {
        return debutDate;
    }

    public void setDebutDate(Date debutDate) {
        this.debutDate = debutDate;
    }

    public Date getFinDate() {
        return finDate;
    }

    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    public boolean isEstFini() {
        return estFini;
    }

    public void setEstFini(boolean estFini) {
        this.estFini = estFini;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }
}
