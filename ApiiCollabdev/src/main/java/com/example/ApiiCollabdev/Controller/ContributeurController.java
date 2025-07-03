package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Repository.ContributionRepository;
import com.example.ApiiCollabdev.Service.ContributeurService;
import com.example.ApiiCollabdev.Service.ContributionService;
import com.example.ApiiCollabdev.entities.Contributeur;
import com.example.ApiiCollabdev.entities.Contribution;
import com.example.ApiiCollabdev.entities.Projet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contributeurs")
public class ContributeurController {
    ContributeurService contributeurService;
    ContributionService contributionService;
    //injection de dépendance du service
    public ContributeurController(ContributeurService contributeurService, ContributionService contributionService)
    {
        this.contributeurService = contributeurService;
        this.contributionService = contributionService;
    }

    //afficher un contributeur
    @GetMapping("/{id}")
    public Contributeur afficherContributeur(@PathVariable("id") int idContributeur){
       return  contributeurService.afficherContributeur(idContributeur);
    }

    //afficher tous les contributeurs
    @GetMapping
    public List<Contributeur> afficherTousLesContributeurs()
    {
        return contributeurService.afficherTousLesContributeurs();
    }

    //ajouter un contributeur
    @PostMapping
    public void ajouterContributeur( @RequestBody  Contributeur contributeur)
    {
        contributeurService.ajouterContributeur(contributeur);
    }

    //lister les projets d'un contributeur
    @GetMapping("/{idContributeur}/projets")
    public List<Projet> afficherListProjet(@PathVariable int idContributeur)
    {
        return contributeurService.afficherListProjet(idContributeur);
    }

    //afficher les contributions d'un contributeur par projet
    @GetMapping("/{idContributeur}/projets/{idProjet}")
    public List<Contribution> afficherContributionParProjet(@PathVariable("idContributeur") int idContributeur,@PathVariable("idProjet") int idProjet){
        return contributeurService.afficherContributionParProjet(idContributeur, idProjet);
    }



    //afficher contributions validées d'un contributeur
    @GetMapping("/{idContributeur}/contributions/valide")
    public List<Contribution> afficherContributionValider(@PathVariable int idContributeur)
    {
       return  contributeurService.afficherContributionValider(idContributeur);
    }
    //afficher contribution non validées d'un contributeur
    @GetMapping("/{idContributeur}/contributions/nonvalide")
    public List<Contribution> afficherContributionNonValider(@PathVariable int idContributeur)
    {
       return contributeurService.afficherContributionNonValider(idContributeur);
    }

    //quitter un projet
    @DeleteMapping("/{idContributeur}/projets/{idProjet}")
    public void quitterProjet(@PathVariable("idContributeur") int idContributeur, @PathVariable("idProjet") int idProjet){
        contributeurService.quitterProjet(idContributeur, idProjet);
    }

    //supprimer un contributeur
    @DeleteMapping("/{idContributeur}")
    public void supprimerContributeur(@PathVariable int idContributeur)
    {
        contributeurService.supprimerContributeur(idContributeur);
    }

    @PutMapping("/{idContributeur}")
    public void modifierContributeur(@PathVariable int idContributeur, @RequestBody  Contributeur contributeur)
    {
        contributeur.setId(idContributeur);
        contributeurService.modifierContributeur(contributeur);
    }





}
