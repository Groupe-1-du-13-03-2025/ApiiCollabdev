package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Repository.PorteurProjetRepository;
import com.example.ApiiCollabdev.entities.PorteurProjet;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
public class PorteurProjetService {

    @Autowired
    private PorteurProjetRepository porteurProjetRepository;


    public Optional<PorteurProjet> getPorteurProjet(long id) {
        return porteurProjetRepository.findById(id);
    }

    public Iterable<PorteurProjet> getAllPorteurProjet() {
        return porteurProjetRepository.findAll();
    }

    public void deletePorteurProjet(long id) {
        porteurProjetRepository.deleteById(id);
    }

    public PorteurProjet savePorteurProjet(PorteurProjet porteurProjet) {
        PorteurProjet savedPoteurProjet = porteurProjetRepository.save(porteurProjet);
        return savedPoteurProjet;
    }
}
