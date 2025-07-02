package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.IdeeProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeeProjetRepository extends JpaRepository<IdeeProjet, Long> {
}
