package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.IdeeProjetService;
import com.example.ApiiCollabdev.Service.InterfaceIdeeProduit;
import com.example.ApiiCollabdev.entities.IdeeProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ideeProjet")
public class IdeeProjetController {
    @Autowired
    InterfaceIdeeProduit interfaceIdeeProduit;
    @PostMapping("/ajouter")
     public String ajouter( @RequestBody IdeeProjet ideeProjet){
        return interfaceIdeeProduit.creerIdeeProjet(ideeProjet);
    }

    @GetMapping("/liste")
    List<IdeeProjet> liste(){
        return interfaceIdeeProduit.ListerIdeeProjet();
    }

    @PutMapping("/modifier")
    public String modifier(@RequestBody IdeeProjet ideeProjet){
          return interfaceIdeeProduit.modifierIdeeProjet(ideeProjet);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable int id){
        return interfaceIdeeProduit.supprimerIdeeProjet(id);
    }

    @GetMapping("rechercher/{id}")
    public IdeeProjet rechercherParId(@PathVariable int id) {
        return interfaceIdeeProduit.rechercherParId(id);
    }
    @GetMapping("/recherche-Titre")
            public IdeeProjet rechercherParTitre(@RequestParam String titre){
        return interfaceIdeeProduit.rechercherParTitre(titre);
    }
    @GetMapping("/rerchercher-Id-Titre")
    public IdeeProjet rechercherParIdAndTitre(@RequestParam int id,String titre){
        return interfaceIdeeProduit.rechercherParIdEtTitre(id, titre);
    }





}
