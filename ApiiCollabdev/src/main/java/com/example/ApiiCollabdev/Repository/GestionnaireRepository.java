package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Integer> {
    Optional<Gestionnaire> findByEmail(String email);
}
