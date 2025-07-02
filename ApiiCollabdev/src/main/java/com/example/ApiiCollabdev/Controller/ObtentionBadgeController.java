package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.ObtentionBadgeService;
import com.example.ApiiCollabdev.entities.ObtentionBadge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obtention-badges")
public class ObtentionBadgeController {
    @Autowired
    private ObtentionBadgeService service;

    @PostMapping
    public ObtentionBadge add(@RequestBody ObtentionBadge obtention){
        return service.ajouterObtentionBadge(obtention);
    }
    @GetMapping
    public List<ObtentionBadge>getAll(){
        return service.getAll();
    }
    @GetMapping("/contributeur/{id}")
    public List<ObtentionBadge> getByContributeur(@PathVariable Long id){
        return service.getByContributeur(id);
    }
    @GetMapping("/badge/{id}")
    public ObtentionBadge getByBadge(@PathVariable Long id){
        return service.getByBadge(id);
    }
}
