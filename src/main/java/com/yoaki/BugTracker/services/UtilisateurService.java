package com.yoaki.BugTracker.services;

import java.util.List;


import com.yoaki.BugTracker.domain.dto.UtilisateurDTO;

public interface UtilisateurService {
    List<UtilisateurDTO> getAllUtilisateurs();
    UtilisateurDTO getUtilisateurById(String id);
    UtilisateurDTO updateUtilisateur(String id,UtilisateurDTO utilisateurDTO);
    void deleteUtilisateur(String id);
    void setAuthUserInDb();
    
}
