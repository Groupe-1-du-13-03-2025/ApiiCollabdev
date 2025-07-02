package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution, Integer> {
    //retourne la liste des contributions d'un projets
    List<Contribution> findByProjet_Id(int idProjet);
   //returne la liste des contribution d'un contributeurs
    List<Contribution> findByContributeur_Id(int idContributeur);
    //retourne la liste des contributions par projet
    List<Contribution> findByContributeur_IdAndProjet_Id(int idContributeur, int idProjet);
    //supprimer les contributions d'un projet = quitter le projet
    void deleteAllByContributeur_IdAndProjet_Id(int idContributeur, int idProjet);
}
