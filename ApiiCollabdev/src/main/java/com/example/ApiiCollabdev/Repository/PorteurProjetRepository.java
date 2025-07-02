package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.PorteurProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PorteurProjetRepository extends CrudRepository<PorteurProjet, Long> {
}
