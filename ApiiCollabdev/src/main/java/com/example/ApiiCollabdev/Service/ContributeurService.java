package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.ContributeurRepository;
import com.example.ApiiCollabdev.entities.Contributeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContributeurService {

    @Autowired
    private ContributeurRepository contributeurRepository;

    public Optional<Contributeur> findByEmail(String email) {
        return contributeurRepository.findByEmail(email);
    }
}
