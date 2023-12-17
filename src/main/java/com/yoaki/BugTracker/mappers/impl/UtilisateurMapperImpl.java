package com.yoaki.BugTracker.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.yoaki.BugTracker.domain.Utilisateur;
import com.yoaki.BugTracker.domain.dto.UtilisateurDTO;
import com.yoaki.BugTracker.mappers.Mapper;

@Component
public class UtilisateurMapperImpl implements Mapper<Utilisateur, UtilisateurDTO> {
    private final ModelMapper modelMapper;

    public UtilisateurMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
		
	@Override
    public UtilisateurDTO mapTo(Utilisateur utilisateur) {
        return modelMapper.map(utilisateur, UtilisateurDTO.class);
    }
		
	@Override
    public Utilisateur mapFrom(UtilisateurDTO utilisateurDTO) {
        return modelMapper.map(utilisateurDTO, Utilisateur.class);
    }
}