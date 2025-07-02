package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.ObtentionBadgeRepository;
import com.example.ApiiCollabdev.entities.ObtentionBadge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ObtentionBadgeService {
    @Autowired
    private ObtentionBadgeRepository obtentionBadgeRepository;
    public ObtentionBadge ajouterObtentionBadge(ObtentionBadge obtention){
        obtention.setDateObtention(new Date());
        return obtentionBadgeRepository.save(obtention);
    }
    public List<ObtentionBadge>getAll(){
        return obtentionBadgeRepository.findAll();
    }
    public List<ObtentionBadge> getByContributeur( Long id){
        return obtentionBadgeRepository.findByContributeurId(id);
    }
    public ObtentionBadge getByBadge(Long id){
        return obtentionBadgeRepository.findByBadgeId(id);
    }
}
