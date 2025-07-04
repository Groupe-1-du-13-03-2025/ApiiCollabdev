package com.example.ApiiCollabdev.Controller;

import com.example.ApiiCollabdev.Service.BadgeService;
import com.example.ApiiCollabdev.entities.Badge;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private BadgeService badgeService;

    // Ajout d'un badge (réservé à l'admin)
    @PostMapping("/upload")
    public ResponseEntity<?> creerBadgeAvecImage(@RequestHeader(value = "Role") String role,
                                                 @RequestParam("titre") String titre,
                                                 @RequestParam("image") MultipartFile file) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Accès refusé : seul un administrateur peut ajouter un badge.");
        }

        try {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());

            Badge badge = new Badge();
            badge.setTitre(titre);
            badge.setUriImage(fileName);

            return ResponseEntity.ok(badgeService.creerBadge(badge));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du badge : " + e.getMessage());
        }
    }

    //  Affichage des badges (admin uniquement)
    @GetMapping
    public ResponseEntity<?> getAllBadges(@RequestHeader("Role") String role) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Accès refusé : seul un administrateur peut voir la liste des badges.");
        }

        return ResponseEntity.ok(badgeService.getAllBadges());
    }

    // Suppression d’un badge (admin uniquement)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerBadge(@RequestHeader("Role") String role,
                                            @PathVariable Integer id) {
        if (!"ADMIN".equalsIgnoreCase(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Accès refusé : seul un administrateur peut supprimer un badge.");
        }

        badgeService.supprimerBadge(id);
        return ResponseEntity.ok("Badge supprimé avec succès.");
    }
}

