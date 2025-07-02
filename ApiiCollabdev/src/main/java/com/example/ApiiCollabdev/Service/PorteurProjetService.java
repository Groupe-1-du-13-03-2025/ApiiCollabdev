package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.PorteurProjetRepository;
import com.example.ApiiCollabdev.entities.PorteurProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PorteurProjetService {

    @Autowired
    private PorteurProjetRepository porteurProjetRepository;

    public Optional<PorteurProjet> findByEmail(String email) {
        return porteurProjetRepository.findByEmail(email);
    }
}
