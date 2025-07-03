package com.example.ApiiCollabdev.Utilitie;
import com.example.ApiiCollabdev.Dto.ContributionDTO;
import com.example.ApiiCollabdev.entities.Contribution;

public class UserMapper {
    static public ContributionDTO ToContributionDTO(Contribution contribution)
    {

        return new ContributionDTO(contribution.getTitre(), contribution.getDescription(), contribution.getDebutDate(),
                contribution.getFinDate(),contribution.getPiecesAGagner(),contribution.isEstFini()
                , contribution.isEstValide());
    }
    static public Contribution ToContributeur(ContributionDTO contributionDTO)
    {
        Contribution contribution = new Contribution();
        contribution.setId(contributionDTO.getId());
        contribution.setTitre(contributionDTO.getTitre());
        contribution.setDescription(contributionDTO.getDescription());
        contribution.setEstValide(contributionDTO.isEstValide());
        contribution.setEstFini(contributionDTO.isEstFini());
        return contribution;
    }
}
