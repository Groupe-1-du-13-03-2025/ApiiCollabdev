package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.entities.enums.Niveau;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private Boolean estFini;
    private Date dateDebut;
    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Contribution> contributions;
    public Projet() {
    }

    private Date dateFin;

    public Projet(int id, String titre, String description, Boolean estFini, Date dateDebut, Date dateFin, Niveau niveauDacces) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.estFini = estFini;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.niveauDacces = niveauDacces;
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

    public Boolean getEstFini() {
        return estFini;
    }

    public void setEstFini(Boolean estFini) {
        this.estFini = estFini;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Niveau getNiveauDacces() {
        return niveauDacces;
    }

    public void setNiveauDacces(Niveau niveauDacces) {
        this.niveauDacces = niveauDacces;
    }

    @Enumerated(EnumType.STRING)
    private Niveau niveauDacces;


}
