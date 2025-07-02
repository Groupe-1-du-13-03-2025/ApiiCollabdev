package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.ContributeurRepository;
import com.example.ApiiCollabdev.Repository.ContributionRepository;
import com.example.ApiiCollabdev.entities.Contributeur;

import java.util.List;
import java.util.Optional;

public class ContributeurService {
    //injection de dépendance
    ContributeurRepository contributeurRepository;
    ContributionRepository contributionRepository;
    public ContributeurService(ContributeurRepository contributeurRepository, ContributionRepository contributionRepository)
    {
        this.contributeurRepository = contributeurRepository;
        this.contributionRepository = contributionRepository;
    }
    //find un contributeur par son id
    public Contributeur afficherContributeur(Long id)
    {
        Optional<Contributeur> contributeurOptional = contributeurRepository.findById(id);
        return contributeurOptional.orElse(null);
    }
    //lister les contributeurs
    public List<Contributeur> afficherTousLesContributeurs()
    {
        return contributeurRepository.findAll();
    }

    //lister ses projets
    public void afficherListProjet(int idContributeur, int idProjet)
    {
        this.contributionRepository.findBy
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
