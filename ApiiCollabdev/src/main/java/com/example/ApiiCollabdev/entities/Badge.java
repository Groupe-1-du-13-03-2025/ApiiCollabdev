package com.example.ApiiCollabdev.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
public class Badge {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String uriImage;
@OneToMany(mappedBy = "badge", cascade = CascadeType.ALL )
    private List<ObtentionBadge> obtention;

    public Badge(Long id, String titre, String uriImage, List<ObtentionBadge> obtention) {
        this.id = id;
        this.titre = titre;
        this.uriImage = uriImage;
        this.obtention = obtention;
    }
// getter
    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getUriImage() {
        return uriImage;
    }

    public List<ObtentionBadge> getObtention() {
        return obtention;
    }
    //setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setUriImage(String uriImage) {
        this.uriImage = uriImage;
    }

    public void setObtention(List<ObtentionBadge> obtention) {
        this.obtention = obtention;
    }

    public Badge() {
    }
}
