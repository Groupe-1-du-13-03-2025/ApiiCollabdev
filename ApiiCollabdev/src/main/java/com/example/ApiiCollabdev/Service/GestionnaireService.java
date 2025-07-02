package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.GestionnaireRepository;
import com.example.ApiiCollabdev.entities.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestionnaireService {

    @Autowired
    private GestionnaireRepository gestionnaireRepository;

    public Optional<Gestionnaire> findByEmail(String email) {
        return gestionnaireRepository.findByEmail(email);
    }
}
