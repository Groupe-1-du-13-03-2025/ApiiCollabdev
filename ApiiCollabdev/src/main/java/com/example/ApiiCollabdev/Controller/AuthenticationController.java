package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Repository.ContributeurRepository;
import com.example.ApiiCollabdev.Service.AuthenticationService;
import com.example.ApiiCollabdev.Service.ContributeurService;
import com.example.ApiiCollabdev.Service.GestionnaireService;
import com.example.ApiiCollabdev.Service.PorteurProjetService;
import com.example.ApiiCollabdev.Service.auth.AuthenticationUserRequest;
import com.example.ApiiCollabdev.entities.Contributeur;
import com.example.ApiiCollabdev.entities.Gestionnaire;
import com.example.ApiiCollabdev.entities.PorteurProjet;
import com.example.ApiiCollabdev.entities.enums.Genre;
import com.example.ApiiCollabdev.entities.enums.Niveau;
import com.example.ApiiCollabdev.entities.enums.Role;
import com.example.ApiiCollabdev.entities.enums.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private ContributeurService contributeurService;

    @Autowired
    private GestionnaireService gestionnaireService;

    @Autowired
    private PorteurProjetService porteurProjetService;

    @Autowired
    private ContributeurRepository contributeurRepository;

    @PostMapping("/test")
    public Boolean test(){
        contributeurRepository.save(
                Contributeur.builder()
                        .nom("Diop")
                        .prenom("Mohamed")
                        .email("mohdiopcode@gmail.com")
                        .type(Type.DEVELOPPEUR)
                        .genre(Genre.M)
                        .role(Role.CONTRIBUTEUR)
                        .niveau(Niveau.INTERMEDIAIRE)
                        .specialite("Ingénieur Logiciel")
                        .pieces(25D)
                        .motDePasse(BCrypt.hashpw("moh", BCrypt.gensalt()))
                        .uriCV("Rien").build()
        );
        return true;
    }

    @PostMapping
    public Boolean login(
            @RequestBody AuthenticationUserRequest user
            ) {
        switch (user.getRole()){
            case CONTRIBUTEUR -> {
                Contributeur contributeur = new Contributeur();
                contributeur.setContributeurService(contributeurService);
                authenticationService.setUser(contributeur);
                return authenticationService.authenticate(user.getEmail(), user.getPassword());
            }
            case GESTIONNAIRE -> {
                Gestionnaire gestionnaire = new Gestionnaire();
                gestionnaire.setGestionnaireService(gestionnaireService);
                authenticationService.setUser(gestionnaire);
                return authenticationService.authenticate(user.getEmail(), user.getPassword());
            }
            case PORTEUR_PROJET -> {
                PorteurProjet porteurProjet = new PorteurProjet();
                porteurProjet.setPorteurProjetService(porteurProjetService);
                authenticationService.setUser(porteurProjet);
                return authenticationService.authenticate(user.getEmail(), user.getPassword());
            }
            default -> {
                return false;
            }
        }
    }
}
