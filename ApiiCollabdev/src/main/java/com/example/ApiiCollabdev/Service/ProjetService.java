package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.GestionnaireRepository;
import com.example.ApiiCollabdev.Repository.ProjetRepository;
import com.example.ApiiCollabdev.entities.Gestionnaire;
import com.example.ApiiCollabdev.entities.Projet;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetService {

    private ProjetRepository projetRepository;
    private GestionnaireRepository gestionnaireRepository;

    //Creer un projet
    public Projet creerProjet(int id, Projet projet){
        Gestionnaire gestionnaire = gestionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gestionnaire introuvable"));
        projet.setGestionnaire(gestionnaire);
        return projetRepository.save(projet);
    }

    //Lister les projet d'un gestionnaire
    public List<Projet> listerLesProjet(int gestionnaireId){
        Gestionnaire gestionnaire = gestionnaireRepository.findById(gestionnaireId)
                .orElseThrow(() -> new RuntimeException("Gestionnaire introuvable"));
        return gestionnaire.getProjets();
    }

    //trouver un projet par nom et par idGestionnaire
    public Projet afficherUnProjetParNomEtParIdGestionnaire(String titre, int gestionnaireId){
        return projetRepository.findByTitreAndGestionnaireId(titre, gestionnaireId)
                .orElseThrow(()-> new RuntimeException("Ce projet n'existe pas"));
    }

    //supprimer un projet
    public void supprimerProjetParId(int gesId, int projetId) {
        Projet projet = projetRepository.findByIdAndGestionnaireId(projetId, gesId)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé ou non associé à ce gestionnaire"));

        projetRepository.delete(projet);
    }
}
