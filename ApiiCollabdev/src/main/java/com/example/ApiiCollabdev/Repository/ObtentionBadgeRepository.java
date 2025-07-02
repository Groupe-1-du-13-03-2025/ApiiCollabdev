package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.ObtentionBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ObtentionBadgeRepository extends JpaRepository<ObtentionBadge,Integer> {
    List<ObtentionBadge> findByContributeurId(Long idContributeur);
    ObtentionBadge findByBadgeId(Long idBadge);
}
