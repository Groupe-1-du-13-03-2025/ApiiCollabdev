package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.Service.GestionnaireService;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Gestionnaire extends Utilisateur {

    @Autowired
    @Transient
    private GestionnaireService gestionnaireService;

    private String uriCv;
    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL)
    private List<Projet> projets = new ArrayList<>();

    @Builder
    public Gestionnaire(long id, String prenom, String nom, String email, String motDePasse, Genre genre, Role role, String uriCv) {
        super(id, prenom, nom, email, motDePasse, genre, role);
        this.uriCv = uriCv;
    }

    @Override
    public Boolean authenticate(String email, String password) {
        Optional<Gestionnaire> optionalGestionnaire = gestionnaireService.findByEmail(email);
        if (optionalGestionnaire.isEmpty()) {
            return false;
        } else {
            Gestionnaire gestionnaire = optionalGestionnaire.get();
            return BCrypt.checkpw(password, gestionnaire.getMotDePasse());
        }
    }
}



