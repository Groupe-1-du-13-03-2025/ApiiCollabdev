package com.example.ApiiCollabdev.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContributionId implements Serializable {
    private int contributeurId;
    private int projetId;

    @Override
    public boolean equals(Object object)
    {
        if(this == object) return  true;
        if(!(object instanceof  ContributionId)) return false;
        ContributionId instance = (ContributionId) object;
        return Objects.equals(contributeurId, instance.contributeurId) &&
                Objects.equals(projetId, instance.projetId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(contributeurId,projetId);
    }
}
