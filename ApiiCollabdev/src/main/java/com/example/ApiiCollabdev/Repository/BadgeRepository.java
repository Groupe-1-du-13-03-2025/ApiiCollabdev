package com.example.ApiiCollabdev.Repository;

import com.example.ApiiCollabdev.entities.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository <Badge, Integer> {

}
