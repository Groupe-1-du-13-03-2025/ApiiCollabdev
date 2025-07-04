package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.BadgeRepository;
import com.example.ApiiCollabdev.entities.Badge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {
    @Autowired
    public BadgeRepository badgeRepository;
    public List<Badge> getAllBadges (){
        return badgeRepository.findAll();
    }

    public Badge creerBadge(Badge badge){
        return  badgeRepository.save(badge);
    }
    public void supprimerBadge(Integer id){
        badgeRepository.deleteById(id);
    }
   public List<Badge> lireTousLesBadges(){
        return badgeRepository.findAll();
   }
   public Badge lireBadgeParId(Integer id){
        return badgeRepository.findById(id).orElse(null);
   }
}
