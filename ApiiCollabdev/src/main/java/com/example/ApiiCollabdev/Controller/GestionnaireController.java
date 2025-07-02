package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Repository.GestionnaireRepository;
import com.example.ApiiCollabdev.Repository.ProjetRepository;
import com.example.ApiiCollabdev.Service.GestionnaireService;
import com.example.ApiiCollabdev.entities.Gestionnaire;
import com.example.ApiiCollabdev.entities.Projet;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestionnaires")
@RequiredArgsConstructor
public class GestionnaireController {
    @Autowired
    private GestionnaireService gestionnaireService;

    @PostMapping
    public Gestionnaire ajouterUnGestionnair( @RequestBody Gestionnaire gestionnaire){
        Gestionnaire ges = gestionnaireService.creerGestionnaire(gestionnaire);
        return ges;
    }

    @GetMapping
    public List<Gestionnaire> afficherLesGestionnaire(){
        return gestionnaireService.afficherLesGestionnaire();
    }

    @GetMapping("/{id}")
    public Gestionnaire afficherUnGestionnaire(@PathVariable int id){
        Gestionnaire gestionnaire = gestionnaireService.afficherUnGestionnaire(id);
        return gestionnaire;
    }

    @DeleteMapping("/{id}")
    public void SupprimerUnGestionnaire(@PathVariable int id){
        gestionnaireService.supprimerGestionnaire(id);
    }
}
