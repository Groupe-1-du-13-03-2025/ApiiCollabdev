package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.IdeeProjetRepository;
import com.example.ApiiCollabdev.entities.IdeeProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IdeeProjetService implements  InterfaceIdeeProduit{
    @Autowired
    IdeeProjetRepository ideeProjetRepository;


    @Override
    public String creerIdeeProjet(IdeeProjet ideeProjet) {
        ideeProjetRepository.save(ideeProjet);
        return "Votre idée de Projet a été ajouter avec succès!!";
    }
    @Override
    public List<IdeeProjet> ListerIdeeProjet() {
        return ideeProjetRepository.findAll();
    }

    @Override
    public String modifierIdeeProjet(IdeeProjet ideeProjet) {
        return "";
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

}
