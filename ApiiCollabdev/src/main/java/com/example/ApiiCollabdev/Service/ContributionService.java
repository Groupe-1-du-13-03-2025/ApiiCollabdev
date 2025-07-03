package com.example.ApiiCollabdev.Service;

import com.example.ApiiCollabdev.Dto.ContributeurDTO;
import com.example.ApiiCollabdev.Dto.ContributionDTO;
import com.example.ApiiCollabdev.Repository.ContributionRepository;
import com.example.ApiiCollabdev.Utilitie.UserMapper;
import com.example.ApiiCollabdev.entities.Contribution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContributionService {

    ContributionRepository contributionRepository;
    //injection de dépendance
    ContributionService(ContributionRepository contributionRepository)
    {
        this.contributionRepository = contributionRepository;
    }
    public Contribution saveContribution(Contribution contribution){
        return contributionRepository.save(contribution);
    }

    public ContributionDTO findById(int id)
    {
        Optional<Contribution> contributionOptional = contributionRepository.findById(id);
        if(contributionOptional.isPresent())
        {
           return  UserMapper.ToContributionDTO(contributionOptional.get());
        }
        return null;
    }

    public List<ContributionDTO> findAll()
    {
        List<Contribution> contributionList = contributionRepository.findAll();
        List<ContributionDTO> contributionDTOList = new ArrayList<>();
        for(Contribution contribution : contributionList)
        {
            contributionDTOList.add(UserMapper.ToContributionDTO(contribution));
        }
        return contributionDTOList;
    }

    public void deleteById(int id)
    {
        contributionRepository.deleteById(id);
    }

    public void updateContribution(int id, ContributionDTO contributionDTO)
    {
        contributionDTO.setId(id);
        contributionRepository.save(UserMapper.ToContributeur(contributionDTO));
    }
}
