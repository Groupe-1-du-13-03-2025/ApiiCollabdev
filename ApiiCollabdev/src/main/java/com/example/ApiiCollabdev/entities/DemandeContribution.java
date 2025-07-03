package com.example.ApiiCollabdev.entities;

import jakarta.persistence.Entity;

import java.util.Date;


public class DemandeContribution {
    private int id;
    private int idContributeur;
    private int idGestionnaire;
    boolean estAccepte;
    private Date dateEnvoi;
}
