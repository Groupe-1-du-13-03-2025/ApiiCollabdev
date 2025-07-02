package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.entities.IdeeProjet;

import java.util.List;

public interface InterfaceIdeeProduit {

    public String creerIdeeProjet(IdeeProjet ideeProjet);
    public List<IdeeProjet>ListerIdeeProjet();
    public  String modifierIdeeProjet(IdeeProjet ideeProjet);
    public String supprimerIdeeProjet(int id);
    public  IdeeProjet rechercherParTitre(String titre);
    public IdeeProjet rechercherParIdEtTitre(int id,String titre);

}
