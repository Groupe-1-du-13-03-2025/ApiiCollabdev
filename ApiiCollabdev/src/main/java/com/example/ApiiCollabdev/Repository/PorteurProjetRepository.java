package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.PorteurProjet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PorteurProjetRepository extends JpaRepository<PorteurProjet, Integer> {
    Optional<PorteurProjet> findByEmail(String email);
}
