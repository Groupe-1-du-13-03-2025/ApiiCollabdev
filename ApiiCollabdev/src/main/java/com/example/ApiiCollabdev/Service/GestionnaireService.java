package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.GestionnaireRepository;
import com.example.ApiiCollabdev.entities.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionnaireService {
    @Autowired
    private GestionnaireRepository gestionnaireRepository;

    //Creer un gestionnaire
    public Gestionnaire creerGestionnaire (Gestionnaire gestionnaire){
        return gestionnaireRepository.save(gestionnaire);
    }

    //Afficher un gestionnaire
    public Gestionnaire afficherUnGestionnaire(int gestionnaireId){
        return gestionnaireRepository.findById(gestionnaireId).orElse(null);
    }

    //Afficher tous les gestionnaire
    public List<Gestionnaire> afficherLesGestionnaire(){
        return gestionnaireRepository.findAll();
    }

    //Supprimer un Gestionnaire
    public void supprimerGestionnaire(int gestionnaire) {
        gestionnaireRepository.deleteById(gestionnaire);
    }

    public Optional<Gestionnaire> findByEmail(String email) {
        return gestionnaireRepository.findByEmail(email);
    }
}
