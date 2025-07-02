package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.IdeeProjet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeeProjetRepository extends JpaRepository<IdeeProjet,Integer> {
    IdeeProjet findByTitre(String titre);
    IdeeProjet findByIdAndTitre(int id,String titre);

}
