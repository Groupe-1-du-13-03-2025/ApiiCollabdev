package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.ContributeurRepository;
import com.example.ApiiCollabdev.entities.Contributeur;

import java.util.Optional;

public class ContributeurService {
    //injection de dépendance
    ContributeurRepository contributeurRepository;
    public ContributeurService(ContributeurRepository contributeurRepository)
    {
        this.contributeurRepository = contributeurRepository;
    }
    //find un contributeur par son id
    public Contributeur afficherContributeur(Long id)
    {
        Optional<Contributeur> contributeurOptional = contributeurRepository.findById(id);
        return contributeurOptional.orElse(null);
    }

    //lister ses projets
    public void afficherListProjet(Long id)
    {

    }

    //lister ses contributions par projet
    public void afficherContributionParProjet(Long idContributeur, Long idProjet){}

    //lister ses contributions valider par projet
    public void afficherContributionValider(Long idContributeur, Long idProjet){}

    //lister ses contributions non valider par projet
    public void afficherContributionNonValider(Long idContributeur, Long idProjet){}

    //quitter un projet
    public void quitterProjet(Long idContributeur, Long idProjet){}

    //modifier un contributeur
    public void modifierContributeur(Contributeur contributeur){}
}
