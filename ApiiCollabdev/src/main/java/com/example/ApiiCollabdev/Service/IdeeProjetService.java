package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.IdeeProjetRepository;
import com.example.ApiiCollabdev.entities.IdeeProjet;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IdeeProjetService implements  InterfaceIdeeProduit{
    @Autowired
    IdeeProjetRepository ideeProjetRepository;


    @Override
    public String creerIdeeProjet(IdeeProjet ideeProjet) {
        ideeProjet.setNombreSoutien(0);
        ideeProjet.setDatePublication(new Date());
        ideeProjetRepository.save(ideeProjet);
        return "Votre idée de Projet a été ajouter avec succès!!";
    }
    @Override
    public List<IdeeProjet> ListerIdeeProjet() {
        return ideeProjetRepository.findAll();
    }

    @Override
    public String modifierIdeeProjet(IdeeProjet ideeProjet) {
        // 1. Vérifie si le projet existe
        Optional<IdeeProjet> ideeExistante = ideeProjetRepository.findById(ideeProjet.getId());

        if (ideeExistante.isPresent()) {
            // 2. Met à jour les champs nécessaires
            IdeeProjet projetAModifier = ideeExistante.get();
            projetAModifier.setTitre(ideeProjet.getTitre());
            projetAModifier.setDescription(ideeProjet.getDescription());
            projetAModifier.setDomaine(ideeProjet.getDomaine());
            // Ajoute les autres champs à mettre à jour si besoin

            // 3. Sauvegarde la modification
            ideeProjetRepository.save(projetAModifier);

            return "Projet modifié avec succès";
        } else {
            return "Projet introuvable";
        }
    }

    @Override
    public String supprimerIdeeProjet(int id) {
        ideeProjetRepository.deleteById(id);
        return "Supprimer avec succès!! ";
    }

    @Override
    public IdeeProjet rechercherParTitre(String titre) {
        return ideeProjetRepository.findByTitre(titre);
    }

    @Override
    public IdeeProjet rechercherParIdEtTitre(int id, String titre) {
        return ideeProjetRepository.findByIdAndTitre(id,titre);
    }

    @Override
    public IdeeProjet rechercherParId(int id) {
        return ideeProjetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet avec ID " + id + " non trouvé."));
    }

    @Override
    public IdeeProjet soutenirIdeeProjet(int id) {
        IdeeProjet projet = ideeProjetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet introuvable"));

        projet.setNombreSoutien(projet.getNombreSoutien() + 1);
        return ideeProjetRepository.save(projet);
    }

}
