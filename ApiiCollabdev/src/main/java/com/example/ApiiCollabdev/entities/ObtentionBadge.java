package com.example.ApiiCollabdev.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ObtentionBadge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idBadge")
    private Badge badge;
    @ManyToOne
    @JoinColumn(name = "idContributeur")
    private Contributeur contributeur;
    private Date dateObtention;

    //constructeur

    public ObtentionBadge() {
    }

    public ObtentionBadge(Long id, Badge badge, Contributeur contributeur, Date dateObtention) {
        this.id = id;
        this.badge = badge;
        this.contributeur = contributeur;
        this.dateObtention = dateObtention;
    }

    // getters

    public Long getId() {
        return id;
    }

    public Badge getBadge() {
        return badge;
    }

    public Contributeur getContributeur() {
        return contributeur;
    }

    public Date getDateObtention() {
        return dateObtention;
    }
    // setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public void setContributeur(Contributeur contributeur) {
        this.contributeur = contributeur;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }
}
