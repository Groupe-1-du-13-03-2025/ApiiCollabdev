package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.ContributeurRepository;
import com.example.ApiiCollabdev.Repository.ContributionRepository;
import com.example.ApiiCollabdev.entities.Contributeur;
import com.example.ApiiCollabdev.entities.Contribution;
import com.example.ApiiCollabdev.entities.Projet;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
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
    public Contributeur afficherContributeur(int idContributeur)
    {
        Optional<Contributeur> contributeurOptional = contributeurRepository.findById(idContributeur);
        return contributeurOptional.orElse(null);
    }
    //ajouter un contributeur
    public Contributeur ajouterContributeur(Contributeur contributeur)
    {
        return contributeurRepository.save(contributeur);
    }
    //lister tous les contributeurs
    public List<Contributeur> afficherTousLesContributeurs()
    {
        return contributeurRepository.findAll();
    }

    //lister les contributeurs d'un projet
    public List<Contributeur> afficherProjetContributeurs(int idProjet)
    {
        List<Contribution> contributionList = contributionRepository.findByProjet_Id(idProjet);
        List<Contributeur> contributeurList = new ArrayList<>();
        for(Contribution contribution : contributionList)
        {
            contributeurList.add(contribution.getContributeur());
        }
        return contributeurList;
    }
    //lister les projets d'un contributeur
    public List<Projet> afficherListProjet(int idContributeur)
    {
      List<Contribution> contributionList = contributionRepository.findByContributeur_Id(idContributeur);
      List<Projet> projetList = new ArrayList<>();
      for(Contribution c : contributionList)
      {
          projetList.add(c.getProjet());
      }
      return projetList;
    }

    //lister ses contributions par projet
    public List<Contribution> afficherContributionParProjet(int idContributeur, int idProjet){
        return contributionRepository.findByContributeur_IdAndProjet_Id(idContributeur, idProjet);
    }

    //lister ses contributions valider par projet
    public List<Contribution> afficherContributionValider(int idContributeur){
        List<Contribution> contributionList = contributionRepository.findByContributeur_Id(idContributeur);
        List<Contribution> contributionValide = new ArrayList<>();
        for(Contribution c : contributionList)
        {
            if(c.isEstValide())
            {
                contributionValide.add(c);
            }
        }
        return contributionValide;
    }

    //lister ses contributions non valider par projet
    public List<Contribution> afficherContributionNonValider(int idContributeur){
        List<Contribution> contributionList = contributionRepository.findByContributeur_Id(idContributeur);
        List<Contribution> contributionValide = new ArrayList<>();
        for(Contribution c : contributionList)
        {
            if(!c.isEstValide())
            {
                contributionValide.add(c);
            }
        }
        return contributionValide;
    }

    //quitter un projet
    public void quitterProjet(int idContributeur, int idProjet){
        contributionRepository.deleteAllByContributeur_IdAndProjet_Id(idContributeur, idProjet);
    }

    public void supprimerContributeur(int idContributeur)
    {
        contributeurRepository.deleteById(idContributeur);
    }

    //modifier un contributeur
    public void modifierContributeur(Contributeur contributeur){
        contributeurRepository.save(contributeur);
    }
}
