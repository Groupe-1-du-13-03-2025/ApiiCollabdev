package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.ProjetService;
import com.example.ApiiCollabdev.entities.Projet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projets")
@RequiredArgsConstructor
public class ProjetController {

    private ProjetService projetService;
    private GestionnaireController gestionnaireController;

    @Autowired
    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @PostMapping("/projet")
    public Projet ajouterunProjet( @RequestParam int id, @RequestBody Projet projet){
       return projetService.creerProjet(id, projet);
    }

    @GetMapping
    public List<Projet> afficherLesProjet(@RequestParam int id){
        return projetService.listerLesProjetParGestionnaireId(id);
    }

}
