package com.yoaki.BugTracker.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoaki.BugTracker.domain.Utilisateur;
import com.yoaki.BugTracker.domain.dto.UtilisateurDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.UtilisateurRepository;
import com.yoaki.BugTracker.services.UtilisateurService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final Mapper<Utilisateur, UtilisateurDTO> utilisateurMapper;

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
            .map(utilisateurMapper::mapTo)
            .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getUtilisateurById(String id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return utilisateurMapper.mapTo(utilisateur);
    }

    @Override
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.mapFrom(utilisateurDTO);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.mapTo(savedUtilisateur);

    }

    @Override
    public void deleteUtilisateur(String id) {
        utilisateurRepository.deleteById(id);
        //Ajouter la fonction qui delete un user d'Auth0
    }

    @Override
    public UtilisateurDTO updateUtilisateur(String id, UtilisateurDTO utilisateurDTO) {
        Utilisateur existingUtilisateur = utilisateurRepository
            .findById(id).orElse(null);
        Utilisateur newUtilisateur = utilisateurMapper.mapFrom(utilisateurDTO);
        
        existingUtilisateur.setName(newUtilisateur.getName());
        existingUtilisateur.setEmail(newUtilisateur.getEmail());
        existingUtilisateur.setPicture(newUtilisateur.getPicture());
        existingUtilisateur.setSubmittedTickets(newUtilisateur.getSubmittedTickets());
        existingUtilisateur.setAssignedTickets(newUtilisateur.getAssignedTickets());
        
        Utilisateur updatedUtilisateur = utilisateurRepository
        .save(existingUtilisateur);
        return utilisateurMapper.mapTo(updatedUtilisateur);
    }


    private void updateDatabaseWithAuth0() {

    }
    
}
