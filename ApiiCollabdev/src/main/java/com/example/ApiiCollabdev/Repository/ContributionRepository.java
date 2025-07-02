package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributionRepository extends JpaRepository<Contribution, Long> {
}
