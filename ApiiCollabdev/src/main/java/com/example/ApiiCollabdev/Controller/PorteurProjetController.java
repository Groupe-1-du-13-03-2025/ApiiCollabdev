package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.PorteurProjetService;
import com.example.ApiiCollabdev.entities.PorteurProjet;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PorteurProjetController {

    @Autowired
    private PorteurProjetService porteurProjetService;

    /**
     * Créer - Ajouter un nouveau porteur de projet
     * @param porteurProjet Un objet ProjetProjet
     * @return L'objet ProjetProjet sauvegardé
     */
    @PostMapping("/porteurProjet")
    public PorteurProjet createPoteurProjet(@RequestBody PorteurProjet porteurProjet) {
        return porteurProjetService.savePorteurProjet(porteurProjet);
    }

    /**
     * Lire - Récupérer un porteur de projet
     * @param id L'identifiant du porteur de projet
     * @return Un objet ProteurProjet entièrement renseigné
     */

    @GetMapping("/porteurProjet/{id}")
    public PorteurProjet getPorteurProjet(@PathVariable long id) {
        Optional<PorteurProjet> porteurProjet = porteurProjetService.getPorteurProjet(id);
        if (porteurProjet.isPresent()) {
            return porteurProjet.get();
        } else {
            return null;
        }
    }

    /**
     * Lire - Récupérer tous les porteurs de projet
     * @return Un objet Iterable contenant tous les employés entièrement renseignés
     */
    @GetMapping("/porteursProjet")
    public Iterable<PorteurProjet> getAllPorteurProjet() {
        return porteurProjetService.getAllPorteurProjet();
    }

    /**
     * Mettre à jour - Modifier un porteur de projet existant
     * @param id L'identifiant du porteur de projet à modifier
     * @param porteurProjet L'objet porteurProjet mis à jour
     * @return L'objet porteurProjet après modification
     */
    @PutMapping("/porteurProjet/{id}")
    public PorteurProjet updatePorteurProjet(@PathVariable ("id") long id, @RequestBody PorteurProjet porteurProjet) {
        Optional<PorteurProjet> p = porteurProjetService.getPorteurProjet(id);
        if (p.isPresent()) {
            PorteurProjet currentPorteurProjet = p.get();

            String prenom = porteurProjet.getPrenom();
            if (prenom != null) {
                currentPorteurProjet.setPrenom(prenom);
            }
            String nom = porteurProjet.getNom();
            if (nom != null) {
                currentPorteurProjet.setNom(nom);
            }
            String email = porteurProjet.getEmail();
            if (email != null) {
                currentPorteurProjet.setEmail(email);
            }
            String motDePasse = porteurProjet.getMotDePasse();
            if (motDePasse != null) {
                currentPorteurProjet.setMotDePasse(motDePasse);
            }
            Genre genre = porteurProjet.getGenre();
            if (genre != null) {
                currentPorteurProjet.setGenre(genre);
            }
            Role role = porteurProjet.getRole();
            if (role != null) {
                currentPorteurProjet.setRole(role);
            }
            porteurProjetService.savePorteurProjet(porteurProjet);
            return porteurProjet;
        } else {
            return null;
        }
    }

    /**
     * Supprimer - Supprimer un porteur de projet
     * @param id L'identifiant du porteur de projet à supprimer
     */
    @DeleteMapping("/porteurProjet/{id}")
    public void deletePorteurProjet(@PathVariable long id) {
        porteurProjetService.deletePorteurProjet(id);
    }



}
