package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.BadgeService;
import com.example.ApiiCollabdev.entities.Badge;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {
@Autowired
    private BadgeService badgeService;
// afficher tout les badges
    @GetMapping
    public List<Badge> getAllBadges(){
        return badgeService.lireTousLesBadges();
    }
    // Afficher un badge par id
   @GetMapping("/{id}")
    public Badge getBadgeById(@PathVariable Long id){
        return badgeService.lireBadgeParId(id);
   }
   // Ajouter un badge
   @PostMapping
    public Badge createBadge(@RequestBody Badge badge){
        return badgeService.creerBadge(badge);
   }
   @DeleteMapping
    public void deleteBadge(@PathVariable Long id){
        badgeService.supprimerBadge(id);
   }
}
