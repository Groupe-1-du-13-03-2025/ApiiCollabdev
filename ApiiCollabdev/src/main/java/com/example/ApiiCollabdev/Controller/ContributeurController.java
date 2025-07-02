package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.ContributeurService;
import com.example.ApiiCollabdev.entities.Contributeur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContributeurController {
    ContributeurService contributeurService;
    //injection de dépendance du service
    public ContributeurController(ContributeurService contributeurService)
    {
        this.contributeurService = contributeurService;
    }

    //afficher un contributeur
    @GetMapping("/{id}")
    public Contributeur afficherContributeur(@PathVariable("id") Long idContributeur){
       return  contributeurService.afficherContributeur(idContributeur);
    }

    //afficher liste de ces projets
    public List<Projet> afficherContributionParProjet(Long idContributeur, Long idProjet){

    }




}
