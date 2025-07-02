package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.ProjetService;
import com.example.ApiiCollabdev.entities.Projet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projet")
@RequiredArgsConstructor
public class ProjetController {
    private ProjetService projetService;

    @PostMapping("/{id}")
    public Projet ajouterunProjet(@PathVariable int id,@RequestBody Projet projet){
       return projetService.creerProjet(id, projet);
    }
}
