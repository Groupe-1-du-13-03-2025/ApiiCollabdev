package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    // ProjetRepository.java
    Optional<Projet> findByTitreAndGestionnaireId(String titre, Integer gestionnaireId);
    Optional<Projet> findByIdAndGestionnaireId(Integer projetId, Integer gestionnaireId);
    List<Projet> findByGestionnaireId(int gestionnaireId);
}
