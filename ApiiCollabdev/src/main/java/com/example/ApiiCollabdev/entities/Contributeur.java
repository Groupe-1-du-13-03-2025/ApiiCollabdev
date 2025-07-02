package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.Service.ContributeurService;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Niveau;
import com.example.ApiiCollabdev.entities.enums.Role;
import com.example.ApiiCollabdev.entities.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "contributeurs")
@Component
public class Contributeur extends Utilisateur {

    @Autowired
    @Transient
    private ContributeurService contributeurService;

    @Column(nullable = false)
    private Niveau niveau;
    @Column(nullable = false)
    private String specialite;
    @Column(nullable = false)
    private Type type;
    @Column(nullable = false)
    private Double pieces;
    private String uriCV;

    @Builder
    public Contributeur(int id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role, Niveau niveau, String specialite, Type type, Double pieces, String uriCV) {
        super(id, prenom, nom, email, BCrypt.hashpw(motDePasse, BCrypt.gensalt()), genre, role);
        this.niveau = niveau;
        this.specialite = specialite;
        this.type = type;
        this.pieces = pieces;
        this.uriCV = uriCV;
    }

    @Override
    public Boolean authenticate(String email, String password) {
        Optional<Contributeur> optionalContributeur = contributeurService.findByEmail(email);
        if (optionalContributeur.isEmpty()) {
            return false;
        } else {
            Contributeur contributeur = optionalContributeur.get();
            return BCrypt.checkpw(password, contributeur.getMotDePasse());
        }
    }
}
