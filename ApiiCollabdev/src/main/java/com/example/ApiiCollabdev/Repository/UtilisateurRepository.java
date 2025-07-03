package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Utilisateur;
import com.example.ApiiCollabdev.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Trouver un utilisateur par email
    Optional<Utilisateur> findByEmail(String email);
    // Trouver tous les utilisateurs par rôle
    List<Utilisateur> findByRole(Role role);
}