package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.ObtentionBadge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObtentionBadgeRepository extends JpaRepository {
    List<ObtentionBadge> findByContributeurId(Long idContributeur);
    List<ObtentionBadge> findByBadgeId(Long idBadge);
}
