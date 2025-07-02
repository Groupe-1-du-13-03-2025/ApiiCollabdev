package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.CommentaireIdeeProjetRepository;
import com.example.ApiiCollabdev.Repository.IdeeProjetRepository;
import com.example.ApiiCollabdev.Repository.UtilisateurRepository;
import com.example.ApiiCollabdev.entities.CommentaireIdeeProjet;
import com.example.ApiiCollabdev.entities.IdeeProjet;
import com.example.ApiiCollabdev.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentaireIdeeProjetService {
    @Autowired
    private CommentaireIdeeProjetRepository commentaireIdeeProjetRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private IdeeProjetRepository ideeProjetRepository;

    public CommentaireIdeeProjet commenter(long utilisateurId, long ideeId, String contenu) {
        Utilisateur user = utilisateurRepository.findById(utilisateurId).orElseThrow();
        IdeeProjet idee = ideeProjetRepository.findById(ideeId).orElseThrow();

        CommentaireIdeeProjet com = new CommentaireIdeeProjet();
        com.setContenu(contenu);
        com.setDateCommentaire(LocalDateTime.now());
        com.setUtilisateur(user);
        com.setIdeeProjet(idee);

        return commentaireIdeeProjetRepository.save(com);
    }

    public List<CommentaireIdeeProjet> getCommentairesParIdee(long ideeId) {
        return commentaireIdeeProjetRepository.findByIdeeProjet(
            ideeProjetRepository.findById(ideeId).orElseThrow()
        );
    }

    public List<CommentaireIdeeProjet> getCommentairesParUtilisateur(long utilisateurId) {
        return commentaireIdeeProjetRepository.findByUtilisateur(
            utilisateurRepository.findById(utilisateurId).orElseThrow()
        );
    }
}
