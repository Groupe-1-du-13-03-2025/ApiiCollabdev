package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.CommentaireIdeeProjetService;
import com.example.ApiiCollabdev.entities.CommentaireIdeeProjet;
import com.example.ApiiCollabdev.entities.IdeeProjet;
import com.example.ApiiCollabdev.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des commentaires sur les idées de projet.
 * Permet d'ajouter un commentaire, de récupérer les commentaires par idée de projet ou par utilisateur.
 */
@RestController
@RequestMapping("/api/commentaires-idee-projet")
public class CommentaireIdeeProjetController {
    @Autowired
    private CommentaireIdeeProjetService commentaireIdeeProjetService;


     // Ajoute un commentaire à une idée de projet.
     // @param utilisateurId l'identifiant de l'utilisateur qui commente
     // @param ideeId l'identifiant de l'idée de projet commentée
     // @param contenu le texte du commentaire
     // @return le commentaire créé

    @PostMapping("/ajouter")
    public CommentaireIdeeProjet ajouterCommentaire(@RequestParam long utilisateurId,
                                                    @RequestParam long ideeId,
                                                    @RequestParam String contenu) {
        return commentaireIdeeProjetService.commenter(utilisateurId, ideeId, contenu);
    }


     // Récupère tous les commentaires associés à une idée de projet donnée.
     // @param ideeId l'identifiant de l'idée de projet
     // @return la liste des commentaires pour cette idée
     @GetMapping("/par-idee/{ideeId}")
    public List<CommentaireIdeeProjet> getCommentairesParIdee(@PathVariable long ideeId) {
        return commentaireIdeeProjetService.getCommentairesParIdee(ideeId);
    }


     // Récupère tous les commentaires faits par un utilisateur donné.
     // @param utilisateurId l'identifiant de l'utilisateur
     // @return la liste des commentaires faits par cet utilisateur
    @GetMapping("/par-utilisateur/{utilisateurId}")
    public List<CommentaireIdeeProjet> getCommentairesParUtilisateur(@PathVariable long utilisateurId) {
        return commentaireIdeeProjetService.getCommentairesParUtilisateur(utilisateurId);
    }
} 