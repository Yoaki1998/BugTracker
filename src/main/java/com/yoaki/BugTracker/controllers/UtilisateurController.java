package com.yoaki.BugTracker.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoaki.BugTracker.domain.dto.UtilisateurDTO;
import com.yoaki.BugTracker.services.UtilisateurService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @GetMapping
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getUtilisateurById(@PathVariable String id) {
        return utilisateurService.getUtilisateurById(id);
    }


    @PutMapping("{id}")
    public UtilisateurDTO updateUtilisateur(@PathVariable String id, @RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.updateUtilisateur(id, utilisateurDTO);
    }

    @PostMapping()
    public UtilisateurDTO savUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        return utilisateurService.saveUtilisateur(utilisateurDTO);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable String id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.ok().build();
    }
    
}
