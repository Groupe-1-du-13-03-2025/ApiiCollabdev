package com.example.ApiiCollabdev.entities;


import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Niveau;
import com.example.ApiiCollabdev.entities.enums.Role;
import com.example.ApiiCollabdev.entities.enums.Type;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.stereotype.Component;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contributeurs")
public class Contributeur extends Utilisateur {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(nullable = false)
    private String specialite;
    @Column(nullable = false)
    private Double pieces;
    @Column(nullable = false)
    private String uriCV;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Double getPieces() {
        return pieces;
    }

    public void setPieces(Double pieces) {
        this.pieces = pieces;
    }

    public String getUriCV() {
        return uriCV;
    }

    public void setUriCV(String uriCV) {
        this.uriCV = uriCV;
    }



    @Builder
    public Contributeur(
            int id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role,
            Niveau niveau, Type type, String specialite, Double pieces, String uriCV) {
        super(id, prenom, nom, email, BCrypt.hashpw(motDePasse, BCrypt.gensalt()), genre, role);
        this.niveau = niveau;
        this.type = type;
        this.specialite = specialite;
        this.pieces = pieces;
        this.uriCV = uriCV;
    }
    public Contributeur(){}
}



