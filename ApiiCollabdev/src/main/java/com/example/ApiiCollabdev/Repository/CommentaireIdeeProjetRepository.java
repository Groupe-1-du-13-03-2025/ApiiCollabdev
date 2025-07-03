package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.CommentaireIdeeProjet;
import com.example.ApiiCollabdev.entities.IdeeProjet;
import com.example.ApiiCollabdev.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentaireIdeeProjetRepository  extends JpaRepository<CommentaireIdeeProjet, Long> {
        List<CommentaireIdeeProjet> findByIdeeProjet(IdeeProjet ideeProjet);
        List<CommentaireIdeeProjet> findByUtilisateur(Utilisateur utilisateur);
    }
