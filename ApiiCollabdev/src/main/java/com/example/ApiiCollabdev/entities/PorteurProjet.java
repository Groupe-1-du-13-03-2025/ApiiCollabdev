package com.example.ApiiCollabdev.entities;

import com.example.ApiiCollabdev.Service.PorteurProjetService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "porteurs_projet")
public class PorteurProjet extends Utilisateur {

    @Autowired
    @Transient
    private PorteurProjetService porteurProjetService;

    @Override
    public Boolean authenticate(String email, String password) {
        Optional<PorteurProjet> optionalPorteurProjet = porteurProjetService.findByEmail(email);
        if(optionalPorteurProjet.isEmpty()){
            return false;
        } else {
            PorteurProjet porteurProjet = optionalPorteurProjet.get();
            return BCrypt.checkpw(password, porteurProjet.getMotDePasse());
        }
    }

    @Builder
    public PorteurProjet(){
        super();
    }
}
