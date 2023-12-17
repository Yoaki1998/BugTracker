package com.yoaki.BugTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoaki.BugTracker.domain.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur, String> {


    
}
