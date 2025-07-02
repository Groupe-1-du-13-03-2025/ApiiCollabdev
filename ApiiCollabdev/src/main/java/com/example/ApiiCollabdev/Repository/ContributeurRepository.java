package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Contributeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContributeurRepository extends JpaRepository<Contributeur, Integer> {
    Optional<Contributeur> findByEmail(String email);
}
